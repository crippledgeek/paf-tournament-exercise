package com.paf.exercise.service;

import com.paf.exercise.mapper.AddPlayerRequestMapper;
import com.paf.exercise.mapper.AddTournamentRequestMapper;
import com.paf.exercise.model.Player;
import com.paf.exercise.model.Players;
import com.paf.exercise.requests.AddPlayerRequest;
import org.springframework.stereotype.Service;

@Service
public class InternalPlayerService implements PlayerService {

    private final DatabaseService databaseService;

    public InternalPlayerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }


    @Override
    public Players getAllPlayers() {
        return databaseService.getAllPlayers();
    }

    @Override
    public Player getPlayer(Long playerId) {
        return databaseService.getPlayer(playerId);
    }

    @Override
    public Player addPlayer(AddPlayerRequest request) {
        return databaseService.addPlayer(AddPlayerRequestMapper.map(request));
    }

    @Override
    public Player updatePlayer(int player_id, Player player) {
        return null;
    }

    @Override
    public void deletePlayer(Long playerId) {
        databaseService.deletePlayer(playerId);

    }

    @Override
    public void addPlayerToTournament(Long playerId, Long tournamentId) {
        databaseService.addPlayerToTournament(playerId, tournamentId);

    }

    @Override
    public void removePlayerFromTournament(Long playerId, Long tournamentId) {
        databaseService.removePlayerFromTournament(playerId, tournamentId);
    }
}
