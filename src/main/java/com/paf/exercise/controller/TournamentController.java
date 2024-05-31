package com.paf.exercise.controller;

import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/tournaments")
public class TournamentController {

    @GetMapping
    public Tournaments getAllTournaments() {
        return null;
    }

    @GetMapping("/{tournament_id}")
    public Tournament getTournament(@PathVariable int tournament_id) {
        return null;
    }

}
