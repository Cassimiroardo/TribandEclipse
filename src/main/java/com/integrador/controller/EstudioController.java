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
		return ResponseEntity.ok(super.t.buscarPorEmailESenha(email, senha));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Estudio>> buscarPorNome(@PathVariable String nome){
		return ResponseEntity.ok(t.buscarPorNome(nome));
	}
	
	@GetMapping("/proximidade/{latitude}/{longitude}/{raio}")
	public ResponseEntity<List<Estudio>> buscarPorProximidade(@PathVariable Double latitude, @PathVariable Double longitude, @PathVariable Double raio) {
		return ResponseEntity.ok(t.buscarPorProximidade(latitude, longitude, raio));
	}

	@GetMapping("/localizacao")
	public ResponseEntity<List<Estudio>> buscarPorLocalizcao(@RequestBody Localizacao localizacao){
		return ResponseEntity.ok(t.buscarPorLocalizacao(localizacao));
	}
	
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Estudio>> buscarPorPreco(@PathVariable Double preco){
		return ResponseEntity.ok(t.buscarPorPreco(preco));
	}
	
	@GetMapping("/horarioDisponivel/{inicio}/{fim}")
	public ResponseEntity<List<Estudio>> buscarPorHorarioDisponivel(@PathVariable Time inicio, @PathVariable Time fim){
		return ResponseEntity.ok(t.buscarPorHorarioDisponivel(inicio, fim));
	}
	
	@GetMapping("/filtro/{latitude}/{longitude}/{raio}/{preco}/{inicio}/{fim}/{ordenacao}")
	public ResponseEntity<List<Estudio>> buscarPorFiltro(@PathVariable Double latitude, @PathVariable Double longitude, @PathVariable Double raio, @PathVariable Double preco, @PathVariable Time inicio, @PathVariable Time fim,@PathVariable int ordenacao, @RequestBody Localizacao localizacao){
		return ResponseEntity.ok(t.buscarPorProximidadeLocalizacaoPrecoHorarioDisponivel(latitude, longitude, raio, localizacao, preco, inicio, fim, ordenacao));
	}
}
