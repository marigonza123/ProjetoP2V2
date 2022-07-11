package com.projetop3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Categorias")

@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//Determinar as categorias
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long codigo;
	
	@Column
    private String nome;
	
	@OneToMany( cascade = {CascadeType.ALL})
	
	// jsonignore evitar loop no joinCollumn
	@JoinColumn
	private List<Produto> produtos;
	

	}
    

