package com.paf.exercise.service;

import com.paf.exercise.model.Player;
import com.paf.exercise.model.Players;
import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;

public interface DatabaseService {
    Tournaments getAllTournaments();
    Tournament getTournament(Long tournamentId);
    Tournament addTournament(Tournament tournament);
    Tournament updateTournament(int tournament_id, Tournament tournament);
    void deleteTournament(Long tournamentId);

    Players getAllPlayers();
    Player getPlayer(Long playerId);

    Player addPlayer(Player player);

    void deletePlayer(Long playerId);

    void removePlayerFromTournament(Long playerId, Long tournamentId);

    void addPlayerToTournament(Long playerId, Long tournamentId);

}
