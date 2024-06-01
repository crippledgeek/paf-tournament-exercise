package com.paf.exercise.model;

import lombok.Builder;
import lombok.Singular;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.paf.exercise.entities.Tournament}
 */
@Builder
public record Tournament(String name, BigDecimal rewardAmount, @Singular List<Player> players) implements Serializable {
}