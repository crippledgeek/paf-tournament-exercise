package com.paf.exercise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.paf.exercise.entities.Player}
 */
@Builder
@Jacksonized
public record Player(String name) implements Serializable {
}