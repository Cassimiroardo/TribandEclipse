package com.integrador.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Estudio;
import com.integrador.model.Localizacao;
import com.integrador.persistencia.EstudioDAO;

@Controller
@RequestMapping("/estudio")
public class EstudioController extends GenericoController<Estudio,EstudioDAO>{

	public EstudioController() {
		super(new EstudioDAO());
		// TODO Auto-generated constructor stub
	}

	//BUSCAR POR EMAIL
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Estudio> buscarPorEmail(@PathVariable String email) {
		return ResponseEntity.ok(super.t.buscarPorEmail(email));
	}
	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<Estudio> buscarPorEmailESenha(@PathVariable String email,@PathVariable String senha) {
		return ResponseEntity.ok(super.t.buscaPorEmailESenha(email, senha));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Estudio>> buscaPorNome(@PathVariable String nome){
		return ResponseEntity.ok(t.buscaPorNome(nome));
	}
	
	@GetMapping("/proximidade/{latitude}/{longitude}/{raio}")
	public ResponseEntity<List<Estudio>> buscaPorProximidade(@PathVariable Double latitude, @PathVariable Double longitude, @PathVariable Double raio) {
		return ResponseEntity.ok(t.buscarPorProximidade(latitude, longitude, raio));
	}

	@GetMapping("/localizacao")
	public ResponseEntity<List<Estudio>> buscaPorLocalizcao(@RequestBody Localizacao localizacao){
		return ResponseEntity.ok(t.buscaPorLocalizacao(localizacao));
	}
	
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Estudio>> buscaPorPreco(@PathVariable Double preco){
		return ResponseEntity.ok(t.buscaPorPreco(preco));
	}
	
	@GetMapping("/horarioDisponivel/{inicio}/{fim}")
	public ResponseEntity<List<Estudio>> buscaPorHorarioDisponivel(@PathVariable Time inicio, @PathVariable Time fim){
		return ResponseEntity.ok(t.buscaPorHorarioDisponivel(inicio, fim));
	}
	
	@GetMapping("/filtro/{latitude}/{longitude}/{raio}/{preco}/{inicio}/{fim}/{ordenacao}")
	public ResponseEntity<List<Estudio>> buscaPorFiltro(@PathVariable Double latitude, @PathVariable Double longitude, @PathVariable Double raio, @PathVariable Double preco, @PathVariable Time inicio, @PathVariable Time fim,@PathVariable int ordenacao, @RequestBody Localizacao localizacao){
		return ResponseEntity.ok(t.buscaPorProximidadeLocalizacaoPrecoHorarioDisponivel(latitude, longitude, raio, localizacao, preco, inicio, fim, ordenacao));
	}
}
