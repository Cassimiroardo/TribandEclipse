package com.integrador.model;
@Tabela(nome="subservico")
public class SubServico extends EntidadeBase {

	@Atributo(nome="descricao",tipo=String.class)
	private String descricao;

	@ChavePrimaria
	@Atributo(nome="id_subservico",tipo=Long.class)
	private Long idSubservico;

	@ChaveEstrangeira
	@Atributo(nome="id_servico",tipo=Servico.class)
	private Servico servico;

	public SubServico() {
		super();

	}

	public SubServico(Long idSubServico, String descricao, Servico servico) {

		super();

		this.idSubservico = idSubServico;
		this.descricao = descricao;
		this.servico = servico;

	}

	@Override
	public Long getId() {
		return idSubservico;
	}

	public void setId(Long id) {
		this.idSubservico = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
