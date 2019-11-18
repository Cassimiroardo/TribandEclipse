package com.integrador.model;

public interface Usuario{


	
	public String getNome() ;

	public void setNome(String nome) ;

	public String getEmail();

	public void setEmail(String email);

	public String getSenha() ;

	public void setSenha(String senha) ;
	
	

	public abstract Foto getFotoPerfil();
	public abstract void setFotoPerfil(Foto foto);
}