package com.integrador.model;
@Tabela(nome="foto")
public class Foto extends EntidadeBase {

	@ChaveEstrangeira
	@Atributo(nome="id_banda",tipo=Banda.class)
	private Banda banda;

	@ChaveEstrangeira
	@Atributo(nome="id_estudio",tipo=Estudio.class)
	private Estudio estudio;

	@ChavePrimaria
	@Atributo(nome="id_foto",tipo=Long.class)
	private Long idFoto;

	@Atributo(nome="path",tipo=String.class)
	private String path;

	public Foto() {
		super();

	}

	public Foto(Long idFoto, String path, Banda banda, Estudio estudio) {
		super();
		this.idFoto = idFoto;
		this.path = path;
		this.banda = banda;
		this.estudio = estudio;

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idFoto;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idFoto = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

}
