package com.aston.esport_equipes.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


public class PlayerApiWeb {
    @Bean
    public WebClient localApiJoueur(){
        return WebClient.create("http://localhost:8080/players");
    }
}
