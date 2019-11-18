package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Chat;
import com.integrador.model.Mensagem;
import com.integrador.persistencia.MensagemDAO;

@Controller
@RequestMapping("/mensagem")
public class MensagemController extends GenericoController<Mensagem,MensagemDAO>{

	public MensagemController() {
		super(new MensagemDAO());
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/chat")
	public ResponseEntity<List<Mensagem>> buscarPorChat(@RequestBody Chat chat){
		return ResponseEntity.ok(t.buscarPorChat(chat));
	}
}
