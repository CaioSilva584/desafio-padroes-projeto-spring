package com.musicas.desafio_padroes_projeto_spring.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthInterceptor implements RequestInterceptor {


    private final String acessToken;

    public AuthInterceptor(String acessToken) {
        this.acessToken = acessToken;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer " + acessToken);
    }
}
