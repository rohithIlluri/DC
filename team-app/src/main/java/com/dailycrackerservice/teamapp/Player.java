package com.dailycrackerservice.teamapp;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "players")
public class Player {

    // Getters and Setters
    @Id
    private String id;
    private String name;
    private String position;

    // Constructors
    public Player() { }

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
