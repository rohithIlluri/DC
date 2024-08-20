package com.dailycrackerservice.teamapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/team")  // Optional: you can specify a base path for the controller
public class TeamController {

    private final WebClient webClient;

    // Constructor with dependency injection
    public TeamController(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://localhost:8081").build();
    }

    @GetMapping("/")
    public List<String> getPlayersForTeam() {
        return webClient
                .get()
                .uri("/players")
                .retrieve()  // Corrected spelling from 'retrive' to 'retrieve'
                .bodyToFlux(String.class)  // Use bodyToFlux for a list of items
                .collectList()  // Collect the Flux into a List
                .block();  // Block to get the result
    }
}
