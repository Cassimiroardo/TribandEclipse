package com.integrador.model;

import java.sql.Date;
import java.util.ArrayList;
@Tabela(nome="estudio")
public class Estudio extends EntidadeBase implements Usuario {

	private ArrayList<Reserva> reservas;
	
	@Atributo(nome="cnpj",tipo=String.class)
	private String cnpj;

	@Atributo(nome="email",tipo=String.class)
	private String email;

	@ChaveEstrangeira
	@Atributo(nome="id_foto",tipo=Foto.class)
	private Foto fotoPerfil;

	@ChavePrimaria
	@Atributo(nome="id_estudio",tipo=Long.class)
	private Long idEstudio;

	@ChaveEstrangeira
	@Atributo(nome="id_localizacao",tipo=Localizacao.class)
	private Localizacao localizacao;

	@Atributo(nome="nome",tipo=String.class)
	private String nome;
	
	@Atributo(nome="senha",tipo=String.class)
	private String senha;
	
	@Atributo(nome="telefone",tipo=String.class)
	private String telefone;

	@Atributo(nome="descricao",tipo=String.class)
	private String descricao;
	
	@Atributo(nome="preco",tipo=Double.class)
	private Double preco;
	
	private ArrayList<Foto> fotos;
	private ArrayList<AvaliacaoEstudio> avaliacoes;
	private ArrayList<Servico> servicos;
	
	

	public Estudio(ArrayList<Reserva> reservas, String cnpj, String email, Foto fotoPerfil, Long idEstudio,
			Localizacao localizacao, String nome, String senha, String telefone, String descricao, Double preco,
			ArrayList<Foto> fotos, ArrayList<AvaliacaoEstudio> avaliacoes, ArrayList<Servico> servicos) {
		super();
		this.reservas = reservas;
		this.cnpj = cnpj;
		this.email = email;
		this.fotoPerfil = fotoPerfil;
		this.idEstudio = idEstudio;
		this.localizacao = localizacao;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.descricao = descricao;
		this.preco = preco;
		this.fotos = fotos;
		this.avaliacoes = avaliacoes;
		this.servicos = servicos;
	}

	public Estudio(){
		super();
	}
	
	//GET E SETS

	@Override
	public Long getId(){
		return this.idEstudio;
	}
	public void setId(Long idEstudio) {
		this.idEstudio = idEstudio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	public Foto getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public ArrayList<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}
	public ArrayList<AvaliacaoEstudio> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(ArrayList<AvaliacaoEstudio> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public ArrayList<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}
	public ArrayList<Reserva> getReservas() {
		return this.reservas;
	}
	public void setAgenda(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	//OUTROS METODOS


	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Servico addServico(Servico novo) {
		this.servicos.add(novo);
		return novo;
	}
	public void removeServico(int indice){
		this.servicos.remove(indice);
	}
	
	public Servico editServico(int indice, Servico novo){
		this.servicos.remove(indice);
		this.servicos.add(indice,novo);
		return novo;
	}
	
	public AvaliacaoBanda Avaliar(int compromissoHorario,int cuidadoEquipamento, Date dataAvaliacaoBanda,Banda banda){
		AvaliacaoBanda avb = new AvaliacaoBanda(banda,compromissoHorario,cuidadoEquipamento,dataAvaliacaoBanda,(long)0);
		banda.addAvaliacao(avb);
		return avb;
	}
	
	public AvaliacaoEstudio addAvaliacao(AvaliacaoEstudio ave){
		this.avaliacoes.add(ave);
		return ave;
	}
	
	public Reserva addReserva(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}
	
}

