package com.paf.exercise.controller;

import com.paf.exercise.model.Player;
import com.paf.exercise.model.Players;
import com.paf.exercise.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;

class PlayerControllerTestData {
    static final List<Player> PLAYERS = List.of(Player.builder().name("Player 1").build(),
                                                Player.builder().name("Player 2").build(),
                                                Player.builder().name("Player 3").build());

    static final Players PLAYERS_RESPONSE = Players.from(PLAYERS);
}