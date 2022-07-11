package com.projetop3.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI OpenAPI() {
		return new OpenAPI().info(new Info().title("API do Projeto P2")
				.description("Desenvolvimento para Servidores-II -- P2 Projeto")
				.version("v0.0.1").contact(new Contact().name("Marina e Vithoria"))
						.license(new License().name("Apache 2.0")
								.url("http://springdoc.org")));}}