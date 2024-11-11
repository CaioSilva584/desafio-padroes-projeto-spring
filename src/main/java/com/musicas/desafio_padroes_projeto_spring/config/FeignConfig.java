package com.musicas.desafio_padroes_projeto_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public AuthInterceptor authInterceptor() {
        String accessToken = "f5d2ad7f1fba40bab1093cf33ef1f026";
        return new AuthInterceptor(accessToken);
    }
}
