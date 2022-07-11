package com.projetop3.springsecurity;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.projetop3.springsecurity.ImplementsUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	ImplementsUserDetailsService userDetailsService;
	
	private BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET,"/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/produtos").permitAll()
		.antMatchers(HttpMethod.GET, "/categorias").permitAll()
		.antMatchers(HttpMethod.POST, "/produtos").permitAll()
		.antMatchers(HttpMethod.POST, "/categorias").permitAll()
		.antMatchers(HttpMethod.GET, "/lista").permitAll()
		.antMatchers(HttpMethod.POST, "/lista").permitAll()
		.antMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	
	
			@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		}
		
}













