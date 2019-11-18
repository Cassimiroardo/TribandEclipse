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

	public List<Reserva> buscarPorBanda(Banda banda){
		return buscarPorAtributoUsandoId("banda",banda);
	}
	
	public List<Reserva> buscarPorEstudio(Estudio estudio){
		return buscarPorAtributoUsandoId("estudio",estudio);
	}

	public List<Reserva> buscarPorEstudioEData(Estudio estudio, Date data){
		return buscar(" WHERE reserva.id_estudio=? AND DATEDIFF(data_reserva,?)>0",new Object[] {estudio.getId(),data});
	}

}
