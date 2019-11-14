package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.Banda;

public class BandaDAO extends GenericoDAO<Banda>{

	public BandaDAO() {
		super(new Banda());
		// TODO Auto-generated constructor stub
	}

	public Banda buscarPorEmail(String email) {
		return buscaUmPorAtributoUsandoSeusAtributos("email",email);
	}
	public List<Banda> buscaPorNome(String nome){
		return buscaPorAtributoUsandoSeusAtributos("nome",nome);
	}

	public Banda buscaPorEmailESenha(String email, String senha) {
		return buscaUmPorAtributosUsandoSeusAtributos(new String[] {"email", "senha"}, new Object[] { email,senha} );
	}
	
	
}
