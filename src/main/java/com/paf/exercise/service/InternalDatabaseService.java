package com.paf.exercise.service;

import com.paf.exercise.exceptions.TournamentNotFoundException;
import com.paf.exercise.mapper.TournamentMapper;
import com.paf.exercise.mapper.TournamentsMapper;
import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;
import com.paf.exercise.repositories.TournamentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InternalDatabaseService implements DatabaseService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;

    public InternalDatabaseService(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
    }

    @Override
    public Tournaments getAllTournaments() {
        return TournamentsMapper.map(tournamentMapper.toDtos(tournamentRepository.findAll()));
    }

    @Override
    public Tournament getTournament(Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                                   .map(tournamentMapper::toDto)
                                   .orElseThrow(()-> new TournamentNotFoundException("Tournament not found with id: " + tournamentId));
    }

    @Override
    public Tournament addTournament(Tournament tournament) {
        return null;
    }

    @Override
    public Tournament updateTournament(int tournament_id, Tournament tournament) {
        return null;
    }

    @Override
    public void deleteTournament(Long tournamentId) {
        tournamentRepository.deleteById(tournamentId);
    }
}
