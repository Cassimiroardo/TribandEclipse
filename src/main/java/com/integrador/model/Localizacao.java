package com.integrador.model;
@Tabela(nome="localizacao")
public class Localizacao extends EntidadeBase {

	@Atributo(nome="bairro",tipo=String.class)
	private String bairro;
	
	@Atributo(nome="cep",tipo=Long.class)
	private Long cep;
	
	@Atributo(nome="cidade",tipo=String.class)
	private String cidade;

	@Atributo(nome="estado",tipo=String.class)
	private String estado;

	@ChavePrimaria
	@Atributo(nome="id_localizacao",tipo=Long.class)
	private Long idLocalizacao;
	
	@Atributo(nome="latitude",tipo=Double.class)
	private Double latitude;
	
	@Atributo(nome="longitude",tipo=Double.class)
	private Double longitude;
	
	@Atributo(nome="numero",tipo=Integer.class)
	private Integer numero;

	@Atributo(nome="rua",tipo=String.class)
	private String rua;
	
	public Localizacao(Long idLocalizacao, Long cep, String estado, String cidade, String bairro, String rua,
			Integer numero, Double latitude, Double longitude) {
		super();
		this.idLocalizacao = idLocalizacao;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public Localizacao(){
		super();

	}
	
	@Override
	public Long getId() {
		return idLocalizacao;
	}
	public void setId(Long id) {
		this.idLocalizacao = id;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
}
	