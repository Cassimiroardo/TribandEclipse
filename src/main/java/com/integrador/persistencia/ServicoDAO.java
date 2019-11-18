package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.classes.Estudio;
import com.integrador.model.classes.Servico;
import com.integrador.persistencia.utilitarios.GenericoDAO;

public class ServicoDAO extends GenericoDAO<Servico>{

	public ServicoDAO() {
		super(new Servico());
		// TODO Auto-generated constructor stub
	}
	public List<Servico> buscarPorEstudio(Estudio estudio){
		return buscarPorAtributoUsandoId("estudio",estudio);
	}
}
