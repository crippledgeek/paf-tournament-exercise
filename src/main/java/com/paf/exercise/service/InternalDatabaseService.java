package com.paf.exercise.service;

import com.paf.exercise.exceptions.PlayerNotFoundException;
import com.paf.exercise.exceptions.TournamentNotFoundException;
import com.paf.exercise.mapper.PlayerMapper;
import com.paf.exercise.mapper.PlayersMapper;
import com.paf.exercise.mapper.TournamentMapper;
import com.paf.exercise.mapper.TournamentsMapper;
import com.paf.exercise.model.Player;
import com.paf.exercise.model.Players;
import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;
import com.paf.exercise.repositories.PlayerRepository;
import com.paf.exercise.repositories.TournamentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InternalDatabaseService implements DatabaseService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public InternalDatabaseService(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper, PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
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
        return tournamentMapper.toDto(tournamentRepository.save(tournamentMapper.toEntity(tournament)));
    }

    @Override
    public Tournament updateTournament(int tournament_id, Tournament tournament) {
        return null;
    }

    @Override
    public void deleteTournament(Long tournamentId) {
        tournamentRepository.deleteById(tournamentId);
    }

    @Override
    public Players getAllPlayers() {
        return PlayersMapper.map(playerMapper.toDtos(playerRepository.findAll()));
    }

    @Override
    public Player getPlayer(Long playerId) {
        return playerRepository.findById(playerId)
                               .map(playerMapper::toDto)
                               .orElseThrow(()-> new PlayerNotFoundException("Player not found with id: " + playerId));
    }

    @Override
    public Player addPlayer(Player player) {
        return playerMapper.toDto(playerRepository.save(playerMapper.toEntity(player)));
    }

    @Override
    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public void removePlayerFromTournament(Long playerId, Long tournamentId) {
        playerRepository.deleteByIdAndTournaments_Id(playerId, tournamentId);

    }

    @Override
    public void addPlayerToTournament(Long playerId, Long tournamentId) {
        com.paf.exercise.entities.Player player = findPlayerById(playerId);
        com.paf.exercise.entities.Tournament tournament = findTournamentById(tournamentId);

        player.getTournaments().add(tournament);
        tournament.getPlayers().add(player);
        playerRepository.save(player);
    }

    private com.paf.exercise.entities.Player findPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                               .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + playerId));
    }

    private com.paf.exercise.entities.Tournament findTournamentById(Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                                   .orElseThrow(() -> new TournamentNotFoundException("Tournament not found with id: " + tournamentId));
    }
}
