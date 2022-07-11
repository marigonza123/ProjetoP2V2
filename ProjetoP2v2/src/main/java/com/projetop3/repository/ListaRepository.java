package com.projetop3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetop3.model.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{
	
	

}
