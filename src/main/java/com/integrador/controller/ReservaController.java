package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Reserva;
import com.integrador.persistencia.ReservaDAO;

@Controller
@RequestMapping("/reserva")
public class ReservaController extends GenericoController<Reserva,ReservaDAO>{

	public ReservaController() {
		super(new ReservaDAO());
		// TODO Auto-generated constructor stub
	}

	
}
