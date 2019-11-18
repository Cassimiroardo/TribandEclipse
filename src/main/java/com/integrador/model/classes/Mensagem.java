package com.integrador.model.classes;

import java.sql.Time;

import com.integrador.model.annotations.Atributo;
import com.integrador.model.annotations.ChaveEstrangeira;
import com.integrador.model.annotations.ChavePrimaria;
import com.integrador.model.annotations.Tabela;
import com.integrador.model.utilitarios.EntidadeBase;
@Tabela(nome="mensagem")
public class Mensagem extends EntidadeBase {
//para atualizaçções futuras o sistema de mensagens sera melhorado

	@ChaveEstrangeira
	@Atributo(nome="id_chat",tipo=Chat.class)
	private Chat chat;

	@Atributo(nome="horario",tipo=Time.class)
	private Time horario;

	@ChavePrimaria
	@Atributo(nome="id_mensagem",tipo=Long.class)
	private Long idMensagem;
	
	@Atributo(nome="conteudo",tipo=String.class)
	private String conteudo;

	public Mensagem() {
		super();

	}


	public Mensagem(Chat chat, Time horario, Long idMensagem, String conteudo) {

		super();

		this.chat = chat;
		this.horario = horario;
		this.idMensagem = idMensagem;
		this.conteudo = conteudo;

	}


	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.idMensagem;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idMensagem = id;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}
