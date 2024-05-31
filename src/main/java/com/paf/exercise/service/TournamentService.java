package com.paf.exercise.service;

import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;

public interface TournamentService {
    Tournaments getAllTournaments();
    Tournament getTournament(Long tournamentId);
    Tournament addTournament(Tournament tournament);
    Tournament updateTournament(int tournament_id, Tournament tournament);
    void deleteTournament(Long tournamentId);
}
