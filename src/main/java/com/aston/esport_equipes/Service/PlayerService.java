package com.aston.esport_equipes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PlayerService {
    private final WebClient localApiClient;

    @Autowired
    public PlayerService(WebClient player){
        this.localApiClient = localApiClient;
    }
}
