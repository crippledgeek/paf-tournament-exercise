package com.paf.exercise.model;

import java.util.List;

public record Tournaments(List<Tournament> tournaments){
    private static final List<Tournament> EMPTY_LIST = List.of();

    public static Tournaments from(List<Tournament> tournaments) {
        return new Tournaments(tournaments);
    }

    public boolean isEmpty() {
        return tournaments == null || tournaments.isEmpty();
    }

    public int size() {
        return isEmpty() ?
               0 :
               tournaments.size();
    }

    public List<Tournament> tournaments() {
        return tournaments.isEmpty() ?
               EMPTY_LIST :
               tournaments;
    }
}
