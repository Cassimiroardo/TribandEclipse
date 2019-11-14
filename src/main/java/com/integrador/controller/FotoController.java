package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Foto;
import com.integrador.persistencia.FotoDAO;

@Controller
@RequestMapping("/foto")
public class FotoController extends GenericoController<Foto,FotoDAO>{

	public FotoController() {
		super(new FotoDAO());
		// TODO Auto-generated constructor stub
	}

	
	
	
}
