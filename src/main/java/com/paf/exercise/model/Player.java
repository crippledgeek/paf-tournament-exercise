package com.paf.exercise.model;

import lombok.Builder;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.paf.exercise.entities.Player}
 */
@Builder
public record Player(String name, Set<Tournament> tournaments) implements Serializable {
}