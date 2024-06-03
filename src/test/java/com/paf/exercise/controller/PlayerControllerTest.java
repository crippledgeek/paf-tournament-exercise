package com.paf.exercise.controller;

import com.paf.exercise.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.paf.exercise.controller.PlayerControllerTestData.PLAYERS_RESPONSE;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;


    @Test
    @DisplayName("should return all players")
    void getAllPlayers() throws Exception {
        when(playerService.getAllPlayers()).thenReturn(PLAYERS_RESPONSE);
        this.mockMvc.perform(get("/api/players"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"players\":[{\"name\":\"Player 1\"},{\"name\":\"Player 2\"},{\"name\":\"Player 3\"}]}"));
    }
}