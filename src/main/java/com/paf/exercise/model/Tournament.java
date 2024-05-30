package com.paf.exercise.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.paf.exercise.entities.Tournament}
 */
public record Tournament(String name, BigDecimal rewardAmount) implements Serializable {
}