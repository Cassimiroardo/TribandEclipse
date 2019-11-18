package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.classes.AvaliacaoBanda;
import com.integrador.model.classes.Banda;
import com.integrador.persistencia.utilitarios.GenericoDAO;

public class AvaliacaoBandaDAO extends GenericoDAO<AvaliacaoBanda>{

	public AvaliacaoBandaDAO() {
		super(new AvaliacaoBanda());
		// TODO Auto-generated constructor stub
	}
	
	public List<AvaliacaoBanda> buscaPorBanda(Banda banda){
		return buscarPorAtributoUsandoId("banda",banda);
	}
	
	
	
}
