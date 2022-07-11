package com.projetop3.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.projetop3.model.Usuario;


public class DetalheUsuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String senha;
	Collection<? extends GrantedAuthority> authorities;
	

	public DetalheUsuario(Usuario usuario) {
		this.login = usuario.getUsername();
		this.senha = usuario.getPassword();
		Collection<? extends GrantedAuthority> authorities; new ArrayList<>();
		
		authorities = usuario.getRoles().stream().map(role -> 
		{
			//Dar admin ou user
			return new SimpleGrantedAuthority("ROLE_".concat(role.getAuthority()));
		}).collect(Collectors.toList());
		
		this.authorities = authorities;
	}
	
	public static DetalheUsuario create(Usuario usuario) {
		return new DetalheUsuario(usuario);
	}

	public Long getId() {
		return id;
	}

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
}