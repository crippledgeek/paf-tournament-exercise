package com.paf.exercise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Singular;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.paf.exercise.entities.Tournament}
 */
@Builder
@Jacksonized
public record Tournament(String name, BigDecimal rewardAmount, @Singular List<Player> players) implements Serializable {
}