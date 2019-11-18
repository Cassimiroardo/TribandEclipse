package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.classes.AvaliacaoEstudio;
import com.integrador.model.classes.Estudio;
import com.integrador.persistencia.utilitarios.GenericoDAO;

public class AvaliacaoEstudioDAO extends GenericoDAO<AvaliacaoEstudio>{

	public AvaliacaoEstudioDAO() {
		super(new AvaliacaoEstudio());
		// TODO Auto-generated constructor stub
	}

	public List<AvaliacaoEstudio> buscaPorEstudio(Estudio estudio){
		return buscarPorAtributoUsandoId("estudio",estudio);
	}
}
