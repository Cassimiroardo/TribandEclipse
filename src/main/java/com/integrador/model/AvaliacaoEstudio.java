package com.integrador.model;

import java.sql.Date;
@Tabela(nome="avaliacao_estudio")
public class AvaliacaoEstudio extends EntidadeBase {
	
	@Atributo(nome="atendimento",tipo=Integer.class)
	private Integer atendimento;
	
	@Atributo(nome="compromisso_horario",tipo=Integer.class)
	private Integer compromissoHorario;

	@Atributo(nome="data_avaliacao_estudio",tipo=Date.class)
	private Date dataAvaliacaoEstudio;

	@ChaveEstrangeira
	@Atributo(nome="id_estudio",tipo=Estudio.class)
	private Estudio estudio;

	@ChavePrimaria
	@Atributo(nome="id_avaliacao_estudio",tipo=Long.class)
	private Long idAvaliacaoEstudio;

	@Atributo(nome="limpeza",tipo=Integer.class)
	private Integer limpeza;

	@Atributo(nome="qualidade_equipamento",tipo=Integer.class)
	private Integer qualidadeEquipamento;

	
	public AvaliacaoEstudio() {
		super();

	}

	


	public AvaliacaoEstudio(Integer atendimento, Integer compromissoHorario, Date dataAvaliacaoEstudio, Estudio estudio,
			Long idAvaliacaoEstudio, Integer limpeza, Integer qualidadeEquipamento) {
		super();
		this.atendimento = atendimento;
		this.compromissoHorario = compromissoHorario;
		this.dataAvaliacaoEstudio = dataAvaliacaoEstudio;
		this.estudio = estudio;
		this.idAvaliacaoEstudio = idAvaliacaoEstudio;
		this.limpeza = limpeza;
		this.qualidadeEquipamento = qualidadeEquipamento;

	}




	// GETS E SETS

	@Override
	public Long getId() {
		return idAvaliacaoEstudio;
	}

	public void setId(Long idAvEstudio) {
		this.idAvaliacaoEstudio = idAvEstudio;
	}

	public Integer getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(Integer limpeza) {
		this.limpeza = limpeza;
	}

	public Integer getCompromissoHorario() {
		return compromissoHorario;
	}


	public void setCompromissoHorario(Integer compromissoHorario) {
		this.compromissoHorario = compromissoHorario;
	}


	public Integer getQualidadeEquipamento() {
		return qualidadeEquipamento;
	}


	public void setQualidadeEquipamento(Integer qualidadeEquipamento) {
		this.qualidadeEquipamento = qualidadeEquipamento;
	}


	public Integer getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Integer atendimento) {
		this.atendimento = atendimento;
	}
	

	public Date getDataAvaliacaoEstudio() {
		return dataAvaliacaoEstudio;
	}

	public void setDataAvaliacaoEstudio(Date dataAvaliacaoEstudio) {
		this.dataAvaliacaoEstudio = dataAvaliacaoEstudio;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}


	// OUTROS METODOS

}