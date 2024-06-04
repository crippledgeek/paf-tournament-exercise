package com.paf.exercise.repositories;

import com.paf.exercise.entities.Tournament;
import com.paf.exercise.exceptions.TournamentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TournamentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TournamentRepository tournamentRepository;

    private Tournament tournament;

    @BeforeEach
    void setUp() {
        tournament = new Tournament();
        tournament.setName("Tournament 1");
        tournament.setRewardAmount(BigDecimal.valueOf(1000.00));
        entityManager.persist(tournament);
        entityManager.flush();
    }

    @Test
    @DisplayName("Should find tournament by id")
    void shouldFindTournamentById() {
        Optional<Tournament> foundTournament = tournamentRepository.findById(tournament.getId());
        assertThat(foundTournament).isPresent();
        assertThat(foundTournament.get().getName()).isEqualTo(tournament.getName());
    }

    @Test
    @DisplayName("Should not find tournament by non-existing id")
    void shouldNotFindTournamentByNonExistingId() {
        Optional<Tournament> foundTournament = tournamentRepository.findById(-1L);
        assertThat(foundTournament).isNotPresent();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> foundTournament.get().getName());
    }
}