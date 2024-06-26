package com.paf.exercise.service;

import com.paf.exercise.model.Player;
import com.paf.exercise.model.Players;
import com.paf.exercise.requests.AddPlayerRequest;

public interface PlayerService {
    Players getAllPlayers();
    Player getPlayer(Long playerId);
    Player addPlayer(AddPlayerRequest request);
    Player updatePlayer(int player_id, Player player);
    void deletePlayer(Long playerId);
    void addPlayerToTournament(Long playerId, Long tournamentId);
    void removePlayerFromTournament(Long playerId, Long tournamentId);
}
