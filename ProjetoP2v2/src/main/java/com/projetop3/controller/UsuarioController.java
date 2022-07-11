package com.projetop3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetop3.model.Usuario;
import com.projetop3.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@GetMapping()
	public List<Usuario> listar() {
		return usuariorepository.findAll();		
	}
	@GetMapping("/{id}")
	public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
		return usuariorepository.findById(id);		
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adcionar(@RequestBody Usuario usuario) {
		return usuariorepository.save(usuario);
	}
	
	@DeleteMapping()
	public void deletar(@RequestBody Usuario usuario) {
		usuariorepository.delete(usuario);
	}
	
	@PutMapping()
	public void atualizar(@RequestBody Usuario usuario) {
		usuariorepository.save(usuario);
	}
}
