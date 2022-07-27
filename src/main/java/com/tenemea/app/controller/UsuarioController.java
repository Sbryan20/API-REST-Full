package com.tenemea.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tenemea.app.model.Usuario;
import com.tenemea.app.service.UsuarioService;



@RestController
@RequestMapping("/api/usuario")
public class UsuarioController  {

	@Autowired
	private UsuarioService usuarioService;
	
	//create usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario u) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(u));
	}
	
	//search usuario
	@GetMapping(value="/{id}")
	public ResponseEntity<?> read(@PathVariable int id){
		Optional<Usuario> osu=usuarioService.findById(id);
		if(!osu.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(osu);
	}
	//update usuario
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Usuario u) {
		Optional<Usuario> us=usuarioService.findById(id);
		if (!us.isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		us.get().setNombre(u.getNombre());
		us.get().setClave(u.getClave());
		us.get().setEmail(u.getEmail());
		us.get().setEstado(u.getEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(us.get()));
	}
	
	@GetMapping("/list")
	public List<Usuario> readAll(){
		List<Usuario> usuario = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return usuario;
	}
	
	//delet usuario
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		if (!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deletById(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
