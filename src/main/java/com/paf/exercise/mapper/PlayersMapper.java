package com.paf.exercise.mapper;

import com.paf.exercise.model.Player;
import com.paf.exercise.model.Players;

import java.util.List;

public class PlayersMapper {
    private PlayersMapper() {
    }

    public static Players map(List<Player> players) {
        return Players.from(players);
    }
}
