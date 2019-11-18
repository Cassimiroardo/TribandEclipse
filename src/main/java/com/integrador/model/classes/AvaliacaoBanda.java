package com.integrador.model.classes;

import java.sql.Date;

import com.integrador.model.annotations.Atributo;
import com.integrador.model.annotations.ChaveEstrangeira;
import com.integrador.model.annotations.ChavePrimaria;
import com.integrador.model.annotations.Tabela;
import com.integrador.model.utilitarios.EntidadeBase;

@Tabela(nome="avaliacao_banda")
public class AvaliacaoBanda extends EntidadeBase{

	@ChaveEstrangeira
	@Atributo(nome="id_banda",tipo=Banda.class)
	private Banda banda;
	
	@Atributo(nome="compromisso_horario",tipo=Integer.class)
	private Integer compromissoHorario;
	
	@Atributo(nome="cuidado_equipamento",tipo=Integer.class)
	private Integer cuidadoEquipamento;
	
	@Atributo(nome="data_avaliacao_banda",tipo=Date.class)
	private Date dataAvaliacaoBanda;
	
	@ChavePrimaria
	@Atributo(nome="id_avaliacao_banda",tipo=Long.class)
	private Long idAvaliacaoBanda;

	


	public AvaliacaoBanda(Banda banda, Integer compromissoHorario, Integer cuidadoEquipamento, Date dataAvaliacaoBanda,
			Long idAvaliacaoBanda) {
		super();
		this.banda = banda;
		this.compromissoHorario = compromissoHorario;
		this.cuidadoEquipamento = cuidadoEquipamento;
		this.dataAvaliacaoBanda = dataAvaliacaoBanda;
		this.idAvaliacaoBanda = idAvaliacaoBanda;

	}

	public AvaliacaoBanda() {
		super();
	}

	//GETS E SETS;
	
	@Override
	public Long getId() {
		return idAvaliacaoBanda;
	}

	public void setId(Long idAvBanda) {
		this.idAvaliacaoBanda = idAvBanda;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Integer getCompromissoHorario() {
		return compromissoHorario;
	}

	public void setCompromissoHorario(Integer compromissoHorario) {
		this.compromissoHorario = compromissoHorario;
	}

	public Integer getCuidadoEquipamento() {
		return cuidadoEquipamento;
	}

	public void setCuidadoEquipamento(Integer cuidadoEquipamento) {
		this.cuidadoEquipamento = cuidadoEquipamento;
	}

	public Date getDataAvaliacaoBanda() {
		return dataAvaliacaoBanda;
	}

	public void setDataAvaliacaoBanda(Date dataAvaliacaoBanda) {
		this.dataAvaliacaoBanda = dataAvaliacaoBanda;
	}



}