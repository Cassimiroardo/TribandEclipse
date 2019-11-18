package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.classes.Estudio;
import com.integrador.model.classes.Servico;
import com.integrador.persistencia.ServicoDAO;

@Controller
@RequestMapping("/servico")
public class ServicoController extends GenericoController<Servico,ServicoDAO>{

	public ServicoController() {
		super(new ServicoDAO());
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/estudio")
	public ResponseEntity<List<Servico>> buscarPorEstudio(@RequestBody Estudio estudio){
		return ResponseEntity.ok(t.buscarPorEstudio(estudio));
	}

}
