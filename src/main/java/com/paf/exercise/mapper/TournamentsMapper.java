package com.paf.exercise.mapper;

import com.paf.exercise.model.Tournament;
import com.paf.exercise.model.Tournaments;

import java.util.List;

public class TournamentsMapper {
    private TournamentsMapper() {}

    public static Tournaments map(List<Tournament> tournaments) {
        return Tournaments.from(tournaments);
    }
}
