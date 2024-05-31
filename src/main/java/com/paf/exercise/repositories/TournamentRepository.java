package com.paf.exercise.repositories;

import com.paf.exercise.entities.Tournament;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends ListCrudRepository<Tournament, Long> {
}