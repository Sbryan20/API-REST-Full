package com.tenemea.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenemea.app.model.Usuario;
import com.tenemea.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return usuariorepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return usuariorepository.findAll(pageable);
	}



	@Override
	@Transactional
	public Usuario save(Usuario u) {
		
		return usuariorepository.save(u);
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(int id) {
		return usuariorepository.findById(id);
	}

	

	@Override
	@Transactional
	public void deletById(int id) {
		usuariorepository.deleteById(id);
		
	}





	
}
