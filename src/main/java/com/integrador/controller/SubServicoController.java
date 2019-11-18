package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Servico;
import com.integrador.model.SubServico;
import com.integrador.persistencia.SubServicoDAO;

@Controller
@RequestMapping("/subservico")
public class SubServicoController extends GenericoController<SubServico,SubServicoDAO>{

	public SubServicoController() {
		super(new SubServicoDAO());
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/servico")
	public ResponseEntity<List<SubServico>> buscarPorServico(@RequestBody Servico servico){
		return ResponseEntity.ok(t.buscarPorServico(servico));
	}

}
