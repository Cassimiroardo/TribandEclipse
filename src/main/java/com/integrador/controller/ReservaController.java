package com.integrador.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.classes.Banda;
import com.integrador.model.classes.Estudio;
import com.integrador.model.classes.Reserva;
import com.integrador.persistencia.ReservaDAO;

@Controller
@RequestMapping("/reserva")
public class ReservaController extends GenericoController<Reserva, ReservaDAO> {

	public ReservaController() {
		super(new ReservaDAO());
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/banda")
	public ResponseEntity<List<Reserva>> buscarPorBanda(@RequestBody Banda banda) {
		return ResponseEntity.ok(t.buscarPorBanda(banda));
	}

	@GetMapping("/estudio")
	public ResponseEntity<List<Reserva>> buscarPorEstudio(@RequestBody Estudio estudio) {
		return ResponseEntity.ok(t.buscarPorEstudio(estudio));
	}

	@GetMapping("/estudio/{data}")
	public ResponseEntity<List<Reserva>> buscarPorEstudioEData(@RequestBody Estudio estudio, @PathVariable String data) {
		Date dateSql = Date.valueOf(data);	
		return ResponseEntity.ok(t.buscarPorEstudioEData(estudio, dateSql));


	}

}
