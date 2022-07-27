package com.tenemea.app.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tenemea.app.model.Usuario;



public interface UsuarioService {

	
	public Iterable<Usuario>findAll();
	public Page<Usuario> findAll(Pageable pageable);
	public Optional<Usuario> findById(int id);
	public Usuario save(Usuario u);
	public void deletById(int id);
	
}
