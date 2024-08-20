package com.dailycrackerservice.teamapp.service;

import com.dailycrackerservice.teamapp.Player;
import com.dailycrackerservice.teamapp.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(String id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(String id, Player player) {
        if (playerRepository.existsById(id)) {
            player.setId(id);
            return playerRepository.save(player);
        } else {
            return null;
        }
    }

    public void deletePlayer(String id) {
        playerRepository.deleteById(id);
    }
}
