package com.integrador.model.classes;

import com.integrador.model.annotations.Atributo;
import com.integrador.model.annotations.ChavePrimaria;
import com.integrador.model.annotations.Tabela;
import com.integrador.model.utilitarios.EntidadeBase;

@Tabela(nome="foto")
public class Foto extends EntidadeBase {

	
	@ChavePrimaria
	@Atributo(nome="id_foto",tipo=Long.class)
	private Long idFoto;

	@Atributo(nome="path",tipo=String.class)
	private String path;

	public Foto() {
		super();

	}

	public Foto(Long idFoto, String path) {
		super();
		this.idFoto = idFoto;
		this.path = path;
		

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

	
}
