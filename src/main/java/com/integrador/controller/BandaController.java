package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Banda;
import com.integrador.persistencia.BandaDAO;

@Controller
@RequestMapping("/banda")
public class BandaController extends GenericoController<Banda,BandaDAO>{

	public BandaController() {
		super(new BandaDAO());
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Banda> buscarPorEmail(@PathVariable String email) {
		return ResponseEntity.ok(t.buscarPorEmail(email));
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Banda>> buscarPorNome(@PathVariable String nome){
		return ResponseEntity.ok(t.buscarPorNome(nome));
	}
	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<Banda> buscarPorEmailESenha(@PathVariable String email, @PathVariable String senha){
		return ResponseEntity.ok(t.buscarPorEmailESenha(email, senha));
	}
	
}
