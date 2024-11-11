package com.musicas.desafio_padroes_projeto_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPadroesProjetoSpringApplication.class, args);
	}

}
