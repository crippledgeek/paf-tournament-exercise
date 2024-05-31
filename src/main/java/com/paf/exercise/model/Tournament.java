package com.paf.exercise.model;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.paf.exercise.entities.Tournament}
 */
@Builder
public record Tournament(String name, BigDecimal rewardAmount) implements Serializable {
}