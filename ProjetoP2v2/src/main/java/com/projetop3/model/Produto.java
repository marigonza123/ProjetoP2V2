package com.projetop3.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Produtos")


@Entity
public class Produto {

	
	//join collumn categoria
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

    private String nome;
    
    private BigDecimal valor;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Categoria categoria;
    
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Lista lista;
    
    
    
}
