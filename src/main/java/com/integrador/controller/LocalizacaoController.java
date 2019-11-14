package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Localizacao;
import com.integrador.persistencia.LocalizacaoDAO;

@Controller
@RequestMapping("/localizacao")
public class LocalizacaoController extends GenericoController<Localizacao,LocalizacaoDAO>{

	public LocalizacaoController() {
		super(new LocalizacaoDAO());
		// TODO Auto-generated constructor stub
	}

	
	
	
}
