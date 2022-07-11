package com.projetop3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetop3.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByLogin(String login);
	
	@Query("SELECT u from Usuario u JOIN FETCH u.roles where u.login = :login")
	Usuario findByUsernameFetchRoles(@Param("login")String login);
	
}
