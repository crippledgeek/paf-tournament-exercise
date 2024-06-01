package com.paf.exercise.service;

import com.paf.exercise.mapper.AddTournamentRequestMapper;
import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;
import com.paf.exercise.requests.AddTournamentRequest;
import org.springframework.stereotype.Service;

@Service
public class InternalTournamentService implements TournamentService {

    private final DatabaseService databaseService;

    public InternalTournamentService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }


    @Override
    public Tournaments getAllTournaments() {
        return databaseService.getAllTournaments();
    }

    @Override
    public Tournament getTournament(Long tournamentId) {
        return databaseService.getTournament(tournamentId);
    }

    @Override
    public Tournament addTournament(AddTournamentRequest tournament) {
        return databaseService.addTournament(AddTournamentRequestMapper.map(tournament));
    }

    @Override
    public Tournament updateTournament(int tournament_id, Tournament tournament) {
        return null;
    }

    @Override
    public void deleteTournament(Long tournamentId) {
        databaseService.deleteTournament(tournamentId);
    }
}
