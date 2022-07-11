package com.projetop3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjetoP2v2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoP2v2Application.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
