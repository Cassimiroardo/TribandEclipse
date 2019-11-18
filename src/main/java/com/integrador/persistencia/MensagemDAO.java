package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.Chat;
import com.integrador.model.Mensagem;

public class MensagemDAO extends GenericoDAO<Mensagem>{

	public MensagemDAO() {
		super(new Mensagem());
		// TODO Auto-generated constructor stub
	}
	public List<Mensagem> buscarPorChat(Chat chat){
		return buscarPorAtributoUsandoId("chat",chat);
	}

}