package com.paf.exercise.model;

import java.util.List;

public record Players(List<Player> players){
    private static final List<Player> EMPTY_LIST = List.of();

    public static Players from(List<Player> locations) {
        return new Players(locations);
    }

    public boolean isEmpty() {
        return players == null || players.isEmpty();
    }

    public int size() {
        return isEmpty() ?
               0 :
               players.size();
    }

    public List<Player> players() {
        return players.isEmpty() ?
               EMPTY_LIST :
               players;
    }
}
