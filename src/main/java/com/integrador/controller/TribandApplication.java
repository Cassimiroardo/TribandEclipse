package com.integrador.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TribandApplication {

	public static void main(String[] args) {

		/*
		 * ; dao.deletar(1); FotoDAO fotoDAO = new FotoDAO(new Foto());
		 * 
		 * Foto foto = fotoDAO.salvar(new Foto((long) 0,"teste3",null,null));
		 * 
		 * AgendaDAO agendaDAO= new AgendaDAO(new Agenda());
		 * 
		 * Agenda agenda = agendaDAO.salvar(new Agenda((long)0,null,null,new
		 * ArrayList<Reserva>()));
		 * 
		 * Banda a = new Banda((long) 0,"jaja","sdf@gmail.com","1234",3,foto,agenda,new
		 * ArrayList<Foto>(),new ArrayList<AvaliacaoBanda>());
		 * 
		 * 
		 * a = dao.salvar(a);
		 * 
		 * agenda.setBanda(a); foto.setBanda(a);
		 * 
		 * agendaDAO.editar(agenda); fotoDAO.editar(foto); dao.editar(a);
		 */
		 SpringApplication.run(TribandApplication.class, args);
	}

}
