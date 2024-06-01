package com.paf.exercise.controller;

import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;
import com.paf.exercise.service.TournamentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public Tournaments getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{tournamentId}")
    public Tournament getTournament(@PathVariable Long tournamentId) {
        return tournamentService.getTournament(tournamentId);
    }

    @DeleteMapping("/{tournamentId}")
    public void deleteTournament(@PathVariable Long tournamentId) {
        tournamentService.deleteTournament(tournamentId);
    }

}
