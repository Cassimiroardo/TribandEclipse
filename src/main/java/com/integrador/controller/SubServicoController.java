package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.SubServico;
import com.integrador.persistencia.SubServicoDAO;

@Controller
@RequestMapping("/subservico")
public class SubServicoController extends GenericoController<SubServico,SubServicoDAO>{

	public SubServicoController() {
		super(new SubServicoDAO());
		// TODO Auto-generated constructor stub
	}

}
