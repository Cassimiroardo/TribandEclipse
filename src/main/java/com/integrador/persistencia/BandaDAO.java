package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.classes.Banda;
import com.integrador.persistencia.utilitarios.GenericoDAO;

public class BandaDAO extends GenericoDAO<Banda>{

	public BandaDAO() {
		super(new Banda());
		// TODO Auto-generated constructor stub
	}

	public Banda buscarPorEmail(String email) {
		return buscarUmPorAtributoUsandoSeusAtributos("email",email);
	}
	public List<Banda> buscarPorNome(String nome){
		return buscarPorAtributoUsandoSeusAtributos("nome",nome);
	}

	public Banda buscarPorEmailESenha(String email, String senha) {
		return buscarUmPorAtributosUsandoSeusAtributos(new String[] {"email", "senha"}, new Object[] { email,senha} );
	}
	
	
}
