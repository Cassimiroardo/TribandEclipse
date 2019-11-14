package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Mensagem;
import com.integrador.persistencia.MensagemDAO;

@Controller
@RequestMapping("/mensagem")
public class MensagemController extends GenericoController<Mensagem,MensagemDAO>{

	public MensagemController() {
		super(new MensagemDAO());
		// TODO Auto-generated constructor stub
	}

}
