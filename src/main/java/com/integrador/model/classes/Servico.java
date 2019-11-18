package com.integrador.model.classes;

import java.util.ArrayList;

import com.integrador.model.annotations.Atributo;
import com.integrador.model.annotations.ChaveEstrangeira;
import com.integrador.model.annotations.ChavePrimaria;
import com.integrador.model.annotations.Tabela;
import com.integrador.model.utilitarios.EntidadeBase;
@Tabela(nome="servico")
public class Servico extends EntidadeBase {

	@Atributo(nome="descricao",tipo=String.class)
	private String descricao;

	@ChaveEstrangeira
	@Atributo(nome="id_estudio",tipo=Estudio.class)
	private Estudio estudio;

	@ChavePrimaria
	@Atributo(nome="id_servico",tipo=Long.class)
	private Long idServico;
	
	private ArrayList<SubServico> subServicos;

	public Servico() {
		super();

	}
	public Servico(Long idServico, String descricao, Estudio estudio, ArrayList<SubServico> subServicos) {

		super();

		this.idServico = idServico;
		this.descricao = descricao;
		this.estudio = estudio;
		this.subServicos = subServicos;

	}


	public Long getId() {
		return idServico;
	}
	public void setId(Long idServico) {
		this.idServico = idServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estudio getEstudio() {
		return estudio;
	}
	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}
	public ArrayList<SubServico> getSubServicos() {
		return subServicos;
	}
	public void setSubServicos(ArrayList<SubServico> subServicos) {
		this.subServicos = subServicos;
	}
	
	// Outros Metodos
	public SubServico addSubServico(SubServico novo){
		this.subServicos.add(novo);
		return novo;
	}
	
	public void removeSubServico(int indice){
		this.subServicos.remove(indice);
	}

	public SubServico editServico(int indice, SubServico novo){
		this.subServicos.remove(indice);
		this.subServicos.add(indice,novo);
		return novo;
	}
	
}
