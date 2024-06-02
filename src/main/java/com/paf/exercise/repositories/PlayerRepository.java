package com.paf.exercise.repositories;

import com.paf.exercise.entities.Player;
import com.paf.exercise.entities.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ListCrudRepository<Player, Long> {
    void deleteByIdAndTournaments_Id(Long playerId, Long tournamentId);
}