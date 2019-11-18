package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.classes.Banda;
import com.integrador.model.classes.Chat;
import com.integrador.model.classes.Estudio;
import com.integrador.persistencia.utilitarios.GenericoDAO;

public class ChatDAO extends GenericoDAO<Chat>{

	public ChatDAO() {
		super(new Chat());
		// TODO Auto-generated constructor stub
	}
	public List<Chat> buscarPorEstudio(Estudio estudio){
		return buscarPorAtributoUsandoId("estudio",estudio);
	}
	public List<Chat> buscarPorBanda(Banda banda){
		return buscarPorAtributoUsandoId("banda",banda);
	}
}
