package com.integrador.model;

import java.util.ArrayList;
@Tabela(nome="chat")
public class Chat extends EntidadeBase{

	@ChaveEstrangeira
	@Atributo(nome="id_banda",tipo=Banda.class)
	private Banda banda;
	
	@ChaveEstrangeira
	@Atributo(nome="id_estudio",tipo=Estudio.class)
	private Estudio estudio;

	@ChavePrimaria
	@Atributo(nome="id_chat",tipo=Long.class)
	private Long idChat;
	
	private ArrayList<Mensagem> mensagens;
	
	public Chat(Long idChat, Banda banda, Estudio estudio, ArrayList<Mensagem> mensagens) {
		super();
		this.idChat = idChat;
		this.banda = banda;
		this.estudio = estudio;
		this.mensagens = mensagens;

	}

	public Chat() {
		super();

	}

	@Override
	public Long getId(){
		return this.idChat;
	}
	public void setId(Long id) {
		this.idChat = id;
	}
	
	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public void addMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
