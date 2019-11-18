package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.classes.Banda;
import com.integrador.persistencia.BandaDAO;

@Controller
@RequestMapping("/banda")
public class BandaController extends GenericoController<Banda, BandaDAO> {

	public BandaController() {
		super(new BandaDAO());
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Banda> buscarPorEmail(@PathVariable String email) {
		Banda p = t.buscarPorEmail(email);
		if(p!=null)
		return ResponseEntity.ok(p);
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Banda>> buscarPorNome(@PathVariable String nome) {
		List<Banda> p = t.buscarPorNome(nome);
		if(p!=null)
		return ResponseEntity.ok(p);
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<Banda> buscarPorEmailESenha(@PathVariable String email, @PathVariable String senha) {
		Banda p = super.t.buscarPorEmailESenha(email, senha);
		if (p != null)
			return ResponseEntity.ok(p);
		return ResponseEntity.notFound().build();
	}

}
