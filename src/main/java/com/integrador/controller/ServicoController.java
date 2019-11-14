package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Servico;
import com.integrador.persistencia.ServicoDAO;

@Controller
@RequestMapping("/servico")
public class ServicoController extends GenericoController<Servico,ServicoDAO>{

	public ServicoController() {
		super(new ServicoDAO());
		// TODO Auto-generated constructor stub
	}

}
