package com.integrador.persistencia;

import java.sql.Date;
import java.util.List;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;
import com.integrador.model.Reserva;

public class ReservaDAO extends GenericoDAO<Reserva>{

	public ReservaDAO() {
		super(new Reserva());
		// TODO Auto-generated constructor stub
	}

	public List<Reserva> buscaPorBanda(Banda banda){
		return buscaPorAtributoUsandoId("banda",banda);
	}
	
	public List<Reserva> buscaPorEstudio(Estudio estudio){
		return buscaPorAtributoUsandoId("estudio",estudio);
	}

	public List<Reserva> buscaPorEstudioEData(Estudio estudio, Date data){
		return busca(" WHERE id_estudio=? AND data_reserva>=?",new Object[] {estudio.getId(),data});
	}

}
