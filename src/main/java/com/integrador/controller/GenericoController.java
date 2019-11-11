package com.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.integrador.model.EntidadeBase;
import com.integrador.persistencia.GenericoDAO;

import java.util.List;



public abstract class GenericoController<P extends EntidadeBase,T extends GenericoDAO<P>> {

	protected T t;
	
	public GenericoController(T t) {
		this.t = t;
	}
	
	//BUSCAR TODOS
	
	@GetMapping("")
	public ResponseEntity<List<P>> buscarTodos(){
		return ResponseEntity.ok(this.t.buscarTodos());
	} 
	
	//BUSCAR POR ID
	
	@GetMapping("/{id}")
	public ResponseEntity<P> BuscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(this.t.buscarPorId(id));
	}
	
	//SALVAR
	
	@PostMapping("/")
	public ResponseEntity<P> Adicionar(@RequestBody P p){
		return ResponseEntity.ok(this.t.salvar(p));
	}
	
	//DELETAR
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> Deletar(@PathVariable Long id){
		return ResponseEntity.ok(this.t.deletar(id));
	}
	
	//EDITAR
	
	@PutMapping("")
	public ResponseEntity<P> Editar(@RequestBody P p){
		return ResponseEntity.ok(this.t.editar(p));
	}
	
}
