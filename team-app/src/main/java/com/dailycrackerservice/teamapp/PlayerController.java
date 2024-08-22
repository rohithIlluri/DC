package com.dailycrackerservice.teamapp;


import com.dailycrackerservice.teamapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository playerRepository;    @GetMapping

    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String id, @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(id, player);
        return updatedPlayer != null
                ? ResponseEntity.ok(updatedPlayer)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable String id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllPlayers() {
        playerRepository.deleteAll();
        return new ResponseEntity<>("All players deleted successfully", HttpStatus.OK);
    }
}
