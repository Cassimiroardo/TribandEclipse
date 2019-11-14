package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.Estudio;
import com.integrador.model.Servico;

public class ServicoDAO extends GenericoDAO<Servico>{

	public ServicoDAO() {
		super(new Servico());
		// TODO Auto-generated constructor stub
	}
	public List<Servico> buscaPorEstudio(Estudio estudio){
		return buscaPorAtributoUsandoId("estudio",estudio);
	}
}
