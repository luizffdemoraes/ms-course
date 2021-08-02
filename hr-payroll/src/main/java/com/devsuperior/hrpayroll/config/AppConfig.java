package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /*
     -> Esse metodo serve para registrar uma instancia unica;
     -> Criar um componente a partir de uma chamada de metodo;
     */

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
