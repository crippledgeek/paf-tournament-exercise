package com.paf.exercise.service;

import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;
import com.paf.exercise.requests.AddTournamentRequest;

public interface TournamentService {
    Tournaments getAllTournaments();
    Tournament getTournament(Long tournamentId);
    Tournament addTournament(AddTournamentRequest tournament);
    Tournament updateTournament(int tournament_id, Tournament tournament);
    void deleteTournament(Long tournamentId);
}
