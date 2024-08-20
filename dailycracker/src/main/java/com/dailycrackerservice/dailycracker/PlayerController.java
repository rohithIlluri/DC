package com.dailycrackerservice.dailycracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    @GetMapping("/players")
    public List<String>getPlayers() throws InterruptedException {
        Thread.sleep(5000);
        return List.of("MSD","KOHLI","ABD");
    }

}
