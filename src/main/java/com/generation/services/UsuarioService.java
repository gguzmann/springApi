package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	//LLamar repository
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void saveUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public List<Usuario> fiddall() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

}
