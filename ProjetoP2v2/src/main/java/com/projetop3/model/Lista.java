package com.projetop3.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
	import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
	import lombok.EqualsAndHashCode;
	import lombok.Getter;
	import lombok.Setter;

	


	@Getter
	@Setter
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@Table(name = "Lista")
	
@Entity
public class Lista implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		@EqualsAndHashCode.Include
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		private Long id;
		
		private String nome;
		
		
		@ManyToMany
		// jsonignore evitar loop no joinCollumn
		@JsonIgnore
		private List<Produto> produtos;
		
		@ManyToOne
		
		private Usuario usuario;

		
	
}
