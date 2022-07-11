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

import com.projetop3.model.Lista;
import com.projetop3.repository.ListaRepository;

import lombok.AllArgsConstructor;

	@AllArgsConstructor
	@RestController
	@RequestMapping("/listas")
	
public class ListaController {
		
		@Autowired
		private ListaRepository listarepository;
		
		@GetMapping()
		public List<Lista> listar() {
			return listarepository.findAll();		
			
		}
		
		@GetMapping("/{id}")
		public Optional<Lista> getListaById(@PathVariable Long id) {
			return listarepository.findById(id);
			
		}
		
		@PostMapping()
		@ResponseStatus(HttpStatus.CREATED)
		public Lista adcionar(@RequestBody Lista lista) {
			return listarepository.save(lista);
		}
		
		@DeleteMapping("/{id}")
		public void deletar(@PathVariable Long id) {
			listarepository.deleteById(id);
		
			
		}
		
		@PutMapping()
		public void atualizar(@RequestBody Lista lista) {
			listarepository.save(lista);
		}

}
