package com.integrador.persistencia;


import com.integrador.model.classes.Foto;
import com.integrador.persistencia.utilitarios.GenericoDAO;

public class FotoDAO extends GenericoDAO<Foto> {

	public FotoDAO() {
		super(new Foto());
		// TODO Auto-generated constructor stub
	}

}
