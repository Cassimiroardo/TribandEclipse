package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.AvaliacaoEstudio;
import com.integrador.model.Estudio;

public class AvaliacaoEstudioDAO extends GenericoDAO<AvaliacaoEstudio>{

	public AvaliacaoEstudioDAO() {
		super(new AvaliacaoEstudio());
		// TODO Auto-generated constructor stub
	}

	public List<AvaliacaoEstudio> buscaPorEstudio(Estudio estudio){
		return buscaPorAtributoUsandoId("estudio",estudio);
	}
}
