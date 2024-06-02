package com.paf.exercise.controller;

import com.paf.exercise.model.Players;
import com.paf.exercise.requests.AddPlayerRequest;
import com.paf.exercise.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/players")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Players getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public void addPlayer(@RequestBody AddPlayerRequest request) {
        playerService.addPlayer(request);

    }


}
