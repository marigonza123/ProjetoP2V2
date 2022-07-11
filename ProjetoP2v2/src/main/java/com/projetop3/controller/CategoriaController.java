package com.projetop3.controller;

import java.util.List;

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

import com.projetop3.model.Categoria;
import com.projetop3.repository.CategoriaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriarepository;
	
	@GetMapping
	public List <Categoria> listar() {
		return categoriarepository.findAll();
	}
	@GetMapping("/{id}")
	public Categoria getCategoriaById(@PathVariable Long id) {
		return categoriarepository.findById(id).get();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria adicionar(@RequestBody Categoria categoria) {
		return categoriarepository.save(categoria);
	}
	@DeleteMapping()
	public void deletar(@RequestBody Categoria categoria) {
		categoriarepository.delete(categoria);
	}
	@PutMapping()
	public void atualizar(@RequestBody Categoria categoria) {
		categoriarepository.save(categoria);
	}
	
}

