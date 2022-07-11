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

import com.projetop3.model.Produto;
import com.projetop3.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

	@AllArgsConstructor
	@RestController
	@RequestMapping("/produtos")
	public class ProdutoController {

		@Autowired
		private ProdutoRepository produtorepository;
		
		@GetMapping()
		public List<Produto> listar() {
			return produtorepository.findAll();		
			
		}
		
		@GetMapping("/{id}")
		public Optional<Produto> getProdutoById(@PathVariable Long id) {
			return produtorepository.findById(id);
			
		}
		
		@PostMapping()
		@ResponseStatus(HttpStatus.CREATED)
		public Produto adcionar(@RequestBody Produto produto) {
			return produtorepository.save(produto);
		}
		
		@DeleteMapping()
		public void deletar(@RequestBody Produto produto) {
			produtorepository.delete(produto);
		
			
		}
		
		@PutMapping()
		public void atualizar(@RequestBody Produto produto) {
			produtorepository.save(produto);
		}
	}

