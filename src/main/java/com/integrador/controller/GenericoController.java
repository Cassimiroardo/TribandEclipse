package com.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.integrador.model.annotations.Tabela;
import com.integrador.model.classes.Estudio;
import com.integrador.model.classes.Foto;
import com.integrador.model.classes.Localizacao;
import com.integrador.model.utilitarios.EntidadeBase;
import com.integrador.model.utilitarios.Usuario;
import com.integrador.persistencia.FotoDAO;
import com.integrador.persistencia.LocalizacaoDAO;
import com.integrador.persistencia.utilitarios.GenericoDAO;
import com.integrador.persistencia.utilitarios.Parser;

import java.lang.reflect.Field;
import java.util.List;

public abstract class GenericoController<P extends EntidadeBase, T extends GenericoDAO<P>> {

	protected T t;

	public GenericoController(T t) {
		this.t = t;
	}

	// BUSCAR TODOS

	@GetMapping("/")
	public ResponseEntity<List<P>> buscarTodos() {
		List<P> lista = this.t.buscarTodos();
		if(lista!=null)
		return ResponseEntity.ok(lista);
		return ResponseEntity.noContent().build();
	}

	// BUSCAR POR ID

	@GetMapping("/id/{id}")
	public ResponseEntity<P> buscarPorId(@PathVariable Long id) {
		P p = this.t.buscarPorId(id);
		if (p != null)
			return ResponseEntity.ok(p);
		return ResponseEntity.notFound().build();
	}

	// SALVAR

	@PostMapping("/")
	public ResponseEntity<P> adicionar(@RequestBody P p) {

		String nomeTabela = p.getClass().getAnnotation(Tabela.class).nome();

		if (nomeTabela.equals("banda") || nomeTabela.equals("estudio")) {

			Foto fotoPerfil = new Foto((long) 0, p.getId() + "/");
			FotoDAO dao = new FotoDAO();
			fotoPerfil = dao.salvar(fotoPerfil);
			((Usuario) p).setFotoPerfil(fotoPerfil);

			if (nomeTabela.equals("estudio")) {
				Localizacao localizacao = ((Estudio) p).getLocalizacao();
				LocalizacaoDAO dao2 = new LocalizacaoDAO();
				localizacao = dao2.salvar(localizacao);
				((Estudio) p).setLocalizacao(localizacao);
			}
		}
		p = this.t.salvar(p);
		if (p != null)
			return ResponseEntity.ok(p);
		return ResponseEntity.badRequest().build();
	}

	// DELETAR

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
		Boolean resultado = this.t.deletar(id);
		if (resultado)
			return ResponseEntity.ok(resultado);
		return ResponseEntity.notFound().build();
	}

	// EDITAR

	@PutMapping("/")
	public ResponseEntity<P> editar(@RequestBody P p) {
		p = this.t.editar(p);
		if (p != null)
			return ResponseEntity.ok(p);

		return ResponseEntity.notFound().build();
	}

}
