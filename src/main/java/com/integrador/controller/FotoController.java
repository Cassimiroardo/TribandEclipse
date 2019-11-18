package com.integrador.controller;


import java.io.File;
import java.io.FileOutputStream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.integrador.model.annotations.Tabela;
import com.integrador.model.classes.Banda;
import com.integrador.model.classes.Estudio;
import com.integrador.model.classes.Foto;
import com.integrador.model.utilitarios.Usuario;
import com.integrador.persistencia.BandaDAO;
import com.integrador.persistencia.EstudioDAO;
import com.integrador.persistencia.FotoDAO;

@Controller
@RequestMapping("/foto")
public class FotoController{ //extends GenericoController<Foto,FotoDAO>{
	private final String path = "";
	
	@PostMapping("/")
	public ResponseEntity<Foto> adiciona(MultipartFile imagem, @RequestBody Usuario usuario){
		if (imagem != null) {
			try {
				
				String pathImagem = path + imagem.getOriginalFilename();
				File f = new File(pathImagem);
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(imagem.getBytes());
				fos.close();
				FotoDAO dao = new FotoDAO();
				Foto foto = new Foto((long)0,path + imagem.getOriginalFilename());
				foto = dao.salvar(foto);
				
				if(usuario.getFotoPerfil()!=null) {
					dao.deletar(usuario.getFotoPerfil().getId());
				}
				
				
				usuario.setFotoPerfil(foto);
				String nomeTabela = usuario.getClass().getAnnotation(Tabela.class).nome();
				
				if(nomeTabela.equals("banda")) {
					BandaDAO bandaDao = new BandaDAO();
					bandaDao.editar((Banda) usuario);
				}
				else { // eh Estudio
					EstudioDAO estudioDao = new EstudioDAO();
					estudioDao.editar((Estudio) usuario);
				}
				
				return ResponseEntity.ok(foto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.noContent().build();
	}

	
	
	
	
	
}
