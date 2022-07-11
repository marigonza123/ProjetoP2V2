package com.projetop3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetop3.model.Categoria;
import com.projetop3.model.Lista;
import com.projetop3.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Iterable<Produto> findByLista(Lista lista);
	Iterable<Produto> findByCategoria(Categoria categoria);
	Optional<Produto> findById(Long id);
	
}
