package com.franquicias.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FranquiciasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranquiciasApiApplication.class, args);
	}

	@GetMapping
	public String Saludo(){
		return "Bienvenido a la Api Franquicias";
	}
}
