package com.integrador.persistencia.utilitarios;

//Atualizar o Model com CHavePrimaria e Chave EStrangeira
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Pair;

import com.integrador.model.annotations.Atributo;
import com.integrador.model.annotations.ChavePrimaria;
import com.integrador.model.annotations.Tabela;
import com.integrador.model.utilitarios.EntidadeBase;

public abstract class GenericoDAO<T extends EntidadeBase> {

	private ConexaoMysql conexao;
	private Field atributos[];
	protected Class<T> classeT;
	private String nomeTabela;
	private int numeroAtributosClasse;
	protected Parser<T> parser;

	@SuppressWarnings("unchecked")
	public GenericoDAO(T auxiliar) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "dudu142414", "triband");
		atributos = auxiliar.getClass().getDeclaredFields();
		numeroAtributosClasse = atributos.length;

		for (int i = 0; i < numeroAtributosClasse; i++) {
			atributos[i].setAccessible(true);
		}

		nomeTabela = auxiliar.getClass().getAnnotation(Tabela.class).nome();
		classeT = (Class<T>) auxiliar.getClass();
		parser = new Parser<T>(auxiliar);

	}

	private PreparedStatement adicionarAtributo(PreparedStatement statement, Object valor, int idx) {

		try {

			statement.setObject(idx, valor);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statement;
	}
	// SALVAR

	public T salvar(T t) {
		this.conexao.abrirConexao();

		ArrayList<Object> valores = new ArrayList<Object>();
		String sqlInsertPart1 = "(";
		String sqlInsertPart2 = "(";
		boolean virgula1 = false;
		for (int i = 0; i < numeroAtributosClasse; i++) {
			if (!atributos[i].isAnnotationPresent(Atributo.class)) {
				continue;
			}

			if (virgula1) {
				sqlInsertPart1 += ",";
				sqlInsertPart2 += ",";
			}
			sqlInsertPart1 += atributos[i].getAnnotation(Atributo.class).nome();
			sqlInsertPart2 += "?";

			virgula1 = true;

			valores.add(parser.geraObjeto(atributos[i], t));

		}
		// adiciona os "?" na query de acordo com o numero de atributos

		String sqlInsert = "INSERT INTO " + nomeTabela + sqlInsertPart1 + ") VALUES" + sqlInsertPart2 + ");";
		System.out.println(sqlInsert);
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);

			int tamanhoTabela = valores.size();
			for (int i = 1; i <= tamanhoTabela; i++) {
				statement = adicionarAtributo(statement, valores.get(i - 1), i);
			}

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();

			if (rs.next()) {
				t.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			t = null;
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();

		}
		return t;
	}

	public boolean deletar(long id) {
		this.conexao.abrirConexao();
		boolean resposta = false;

		String sqlDelete = "DELETE FROM " + nomeTabela + " WHERE id_" + nomeTabela + "=?;";
		System.out.println(sqlDelete);
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);

			statement.setLong(1, id);

			resposta = (statement.executeUpdate() > 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

		return resposta;
	}

	public T editar(T novo) {
		
		
		
		
		
		this.conexao.abrirConexao();
		String sqlUpdate1 = "UPDATE " + nomeTabela + " SET ";
		String sqlUpdate2 = " WHERE id_" + nomeTabela + "=?";
		boolean virgula = false;

		int idChavePrimaria = 0;

		ArrayList<Object> valores = new ArrayList<Object>();
		for (int i = 0; i < numeroAtributosClasse; i++) {
		
			
			if (!atributos[i].isAnnotationPresent(Atributo.class))
				continue;

			valores.add(parser.geraObjeto(atributos[i], novo));

			if (atributos[i].isAnnotationPresent(ChavePrimaria.class)) {
				idChavePrimaria = valores.size()-1;
				continue;
			}
			if (virgula)
				sqlUpdate1 += ", ";

			sqlUpdate1 += atributos[i].getAnnotation(Atributo.class).nome();
			sqlUpdate1 += "=?";

			virgula = true;
		}
		sqlUpdate2 += " ;";
		String sqlUpdate = sqlUpdate1 + sqlUpdate2;

		System.out.println(sqlUpdate);
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			int idx = 1;
			for (int i = 0; i < valores.size(); i++) {

				Object valor = valores.get(i);
				if (i == idChavePrimaria) {

					int indiceChaveNaQuery = valores.size();

					statement = adicionarAtributo(statement, valor, indiceChaveNaQuery);

					continue;
				}

				statement = adicionarAtributo(statement, valor, idx++);

			}

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			novo = null;
		} finally {
			this.conexao.fecharConexao();
		}

		return novo;
	}

	protected List<T> buscar(String query, Object valor) {
		// metodo de auxilio para pesquisar com somente um valor na query;
		Object valores[] = { valor };
		return buscar(query, valores);
	}

	protected List<T> buscar(String query, Object valorEspecifico[]) {
		this.conexao.abrirConexao();
		if (valorEspecifico != null)
			if (valorEspecifico.length == 0)
				query = "";

		ArrayList<T> resultado = new ArrayList<T>();

		try {
			String sqlSelect = "SELECT * FROM " + nomeTabela + " " + parser.geraInnerJoin(classeT) + " " + query + ";";
			// parser.geraInnerJoin() gera inner join caso a tabela possua chaves
			// estrangeiras;

			// caso queira especificar algo no select você deve adicionar na query, e os
			// valores que você precisar botar dentro da query
			// você coloca no vetor "valorEspecifico", na ordem em que devem ser adicionados
			// na query;
			System.out.println(sqlSelect);

			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlSelect);
			if (query.length() > 0) {
				int tam = valorEspecifico.length;
				for (int i = 0; i < tam; i++) {
					statement = adicionarAtributo(statement, valorEspecifico[i], i + 1);
				}
			} // valores são adicionados na query, se for necessario

			ResultSet rs = statement.executeQuery();

			// construtor do tipo da busca, para criar novos objetos da classe;

			while (rs.next()) {

				T novo = parser.geraObjetodeClasse(classeT);

				for (int idx = 0; idx < numeroAtributosClasse; idx++) { // anda pelos atributos da classe

					if (!atributos[idx].isAnnotationPresent(Atributo.class))
						continue; // Passa pelos atributos da classe que não estão na tabela

					String nomeDoAtributo = atributos[idx].getAnnotation(Atributo.class).nome();
					Object valor = rs.getObject(nomeDoAtributo);
					// caso o atributo esteja na tabela, você pega o nome dele na tabela e obtem o
					// valor do registro relacionado com esse atributo

					if (parser.ehChaveEstrangeira(atributos[idx])) {

						// caso seja chave estrangeira um objeto deste tipo é criado, para isso é
						// necessario o construtor deste objeto;
						Class<?> tipoFilho = atributos[idx].getAnnotation(Atributo.class).tipo();

						Field[] atributosFilho = tipoFilho.getDeclaredFields();

						EntidadeBase filhoAux = (EntidadeBase) parser.geraObjetodeClasse(tipoFilho);

						// um objeto do tipoFilho é criado e os seus atributos são setados;
						for (Field atributoFilho : atributosFilho) {
							atributoFilho.setAccessible(true);
							if (!atributoFilho.isAnnotationPresent(Atributo.class))
								continue; // pula os atributos da classe que não estão na tabela

							String nomeAtributo = atributoFilho.getAnnotation(Atributo.class).nome();

							Object valorAtributoFilho = rs.getObject(nomeAtributo);

							if (parser.ehChaveEstrangeira(atributoFilho)) { // se o filho for uma chave estrangeira,
																			// somente o id é guardado;
								Class<?> tipoAtributoFilho = atributoFilho.getAnnotation(Atributo.class).tipo();
								EntidadeBase objAtriFilho = (EntidadeBase) parser.geraObjetodeClasse(tipoAtributoFilho);
								objAtriFilho.setId((Long) valorAtributoFilho);
								// O id é setado no objeto
								valorAtributoFilho = objAtriFilho;
								// valor se torna o objeto
							}

							atributoFilho.set(filhoAux, valorAtributoFilho); // seta o valor do atributo[i] no objeto
																				// Filho;
						}

						valor = filhoAux;
					}

					atributos[idx].set(novo, valor); // seta o valor do atributo[idx] no objeto novo;
				}
				resultado.add(novo); // adiciona novo na lista de resposta;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = null;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = null;
		} finally {
			this.conexao.fecharConexao();
		}

		return resultado;
	}

	public List<T> buscarTodos() {
		return buscar("", null);
	}
	
	
	protected T buscarUmPorAtributoUsandoSeusAtributos(String field, Object valor) {
		List<T> ans = buscarPorAtributoUsandoSeusAtributos(field, valor);
		if (ans.size() == 1)
			return ans.get(0);
		return null;
	}
	protected T buscarUmPorAtributosUsandoSeusAtributos(String[] fields, Object[] valores) {
		List<T> ans = buscarPorAtributosUsandoSeusAtributos(fields, valores);
		if(ans.size()==1)
			return ans.get(0);
		return null;
	}
	
	public T buscarPorId(Long id) {
		String nome = classeT.getSimpleName();
		return buscarUmPorAtributoUsandoSeusAtributos("id" + nome, id);
	}


	protected List<T> buscarPorAtributosUsandoSeusAtributos(String fields[], Object valores[]) {
		String query = "";
		ArrayList<Object> valoresQuery = new ArrayList<Object>();
		try {
			for (int i = 0; i < fields.length; i++) {
				Pair<String, List<Object>> novo = gerarQuery(fields[i], valores[i], query, valoresQuery);
				query = novo.getFirst();
				valoresQuery = (ArrayList<Object>) novo.getSecond();
			}

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		query = " WHERE "+ query;
		
		return buscar(query, valoresQuery.toArray());
	}

	protected List<T> buscarPorAtributoUsandoSeusAtributos(String field, Object valor) {
		String fields[] = { field };
		Object valores[] = { valor };
		return buscarPorAtributosUsandoSeusAtributos(fields, valores);
	}

	
	protected List<T> buscarPorAtributoUsandoId(String field, Object valor){
		Class<?> classe = parser.geraAtributo(field).getType();
		String nomeDaTabela = classe.getAnnotation(Tabela.class).nome();
		String nomeAtributoId = nomeDaTabela+".id_"+nomeDaTabela;
		
		Long id = ((EntidadeBase)valor).getId();
		return buscar(" WHERE "+nomeAtributoId +"=?",id);
	}
	
	protected Pair<String, List<Object>> gerarQuery(String nome, Object valor, String query, List<Object> valoresQuery) {
		try {
			Field atributoQuery = parser.geraAtributo(nome);

			ArrayList<Object> valores;
			if (valoresQuery == null)
				valores = new ArrayList<Object>();
			else
				valores = (ArrayList<Object>) valoresQuery;

			
			
			if (parser.ehChaveEstrangeira(atributoQuery)) {
				Field atributosDaQuery[] = atributoQuery.getType().getDeclaredFields();

				ArrayList<String> nomeDosAtributos = new ArrayList<String>();

				for (Field atributo : atributosDaQuery) {
					atributo.setAccessible(true);
					if (!atributo.isAnnotationPresent(Atributo.class)) {
						atributo = null;
						continue;
					}

					if (parser.ehChavePrimaria(atributo) || parser.ehChaveEstrangeira(atributo)) {
						atributo = null;
						continue;
					}

					Object valorAtributo = atributo.get(valor);
					if (valorAtributo == null) {
						atributo = null;
						continue;
					}
					nomeDosAtributos.add(atributo.getAnnotation(Atributo.class).nome());
					valores.add(valorAtributo);
				}
				String nomeTabelaEstrangeira = atributoQuery.getType().getAnnotation(Tabela.class).nome();
				if(query.length()>0) query+=" AND ";
				query += gerarQuery( nomeDosAtributos.toArray(new String[] {}),nomeTabelaEstrangeira) + " ";
			} else {

				if(query.length()>0) query+=" AND ";
				query += gerarQuery(atributoQuery.getAnnotation(Atributo.class).nome(),nomeTabela) + " ";
				valores.add(valor);
			}
			return Pair.of(query, valores);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected String gerarQuery(String nome,String nomeTabela) { // metodo de auxilio para faciliar o metodo gerarQuery quando se tem
												// somente
												// um nome;
		String vetor[] = { nome };
		return gerarQuery(vetor,nomeTabela);
	}

	protected String gerarQuery(String nomeAtributos[],String nomeTabela) { // gera Query apartir de uma lista de nomes de atributos da
															// tabela
		int tamanho = nomeAtributos.length;

		String sqlQuery = "";
		String nome = nomeTabela;
		boolean and = false;
		for (int i = 0; i < tamanho; i++) {
			if (nomeAtributos[i] == null)
				continue;
			if (and)
				sqlQuery += " AND ";
			sqlQuery += nome + "." + nomeAtributos[i] + "=? ";
			and = true;
		}
		return sqlQuery;
	}

}
