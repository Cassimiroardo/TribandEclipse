package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.classes.AvaliacaoEstudio;
import com.integrador.model.classes.Estudio;
import com.integrador.persistencia.AvaliacaoEstudioDAO;

@Controller
@RequestMapping("/avaliacaoEstudio")
public class AvaliacaoEstudioController extends GenericoController<AvaliacaoEstudio,AvaliacaoEstudioDAO>{

	public AvaliacaoEstudioController() {
		super(new AvaliacaoEstudioDAO());
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/buscaPorEstudio")
	public ResponseEntity<List<AvaliacaoEstudio>> buscaPorEstudio(@RequestBody Estudio estudio){
		return ResponseEntity.ok(t.buscaPorEstudio(estudio));
	}

}
