package com.projetop3.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Usuarios")

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	//criação do usuario + determinar a role no banco de dados
	@Column
	private String login;
	
	
	private String senha;
	
	@Column
	private String email;
	
	@ManyToMany
	@JoinTable( 
	        name = "usuarios_roles", 
	        joinColumns = @JoinColumn (
	          name = "usuario_id", referencedColumnName = "login"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "nomeRole")) 
    private List<Role> roles;
	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
	}
	

