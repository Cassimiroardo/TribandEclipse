package com.integrador.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Banda;
import com.integrador.model.Chat;
import com.integrador.model.Estudio;
import com.integrador.persistencia.ChatDAO;

@Controller
@RequestMapping("/chat")
public class ChatController extends GenericoController<Chat,ChatDAO>{

	public ChatController() {
		super(new ChatDAO());
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/estudio/")
	public ResponseEntity<List<Chat>> buscaPorEstudio(@RequestBody Estudio estudio){
		return ResponseEntity.ok(t.buscaPorEstudio(estudio));
	}
	@GetMapping("/banda/")
	public ResponseEntity<List<Chat>> buscaPorBanda(@RequestBody Banda banda){
		return ResponseEntity.ok(t.buscaPorBanda(banda));
	}
}
