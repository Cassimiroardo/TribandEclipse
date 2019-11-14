package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;
import com.integrador.model.Foto;

public class FotoDAO extends GenericoDAO<Foto> {

	public FotoDAO() {
		super(new Foto());
		// TODO Auto-generated constructor stub
	}
	public List<Foto> buscaPorBanda(Banda banda){
		return buscaPorAtributoUsandoId("banda",banda);
	}
	public List<Foto> buscaPorEstudio(Estudio estudio){
		return buscaPorAtributoUsandoId("estudio",estudio);
	}

}
