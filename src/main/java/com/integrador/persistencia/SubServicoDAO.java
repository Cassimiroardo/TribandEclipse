package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.Servico;
import com.integrador.model.SubServico;

public class SubServicoDAO extends GenericoDAO<SubServico>{

	public SubServicoDAO() {
		super(new SubServico());
		// TODO Auto-generated constructor stub
	}
	public List<SubServico> buscaPorServico(Servico servico){
		return buscaPorAtributo("servico", servico);
	}

}
