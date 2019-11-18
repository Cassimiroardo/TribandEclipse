package com.integrador.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.classes.AvaliacaoBanda;
import com.integrador.model.classes.Banda;
import com.integrador.persistencia.AvaliacaoBandaDAO;

@Controller
@RequestMapping("/avaliacaoBanda")
public class AvaliacaoBandaController extends GenericoController<AvaliacaoBanda,AvaliacaoBandaDAO>{

	public AvaliacaoBandaController() {
		super(new AvaliacaoBandaDAO());
	}
	@GetMapping("/buscaPorBanda")
	public ResponseEntity<List<AvaliacaoBanda>> buscaPorBanda(@RequestBody Banda banda){
		return ResponseEntity.ok(t.buscaPorBanda(banda));
	}
	
	
	
}
