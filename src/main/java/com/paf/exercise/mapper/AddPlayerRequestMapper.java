package com.paf.exercise.mapper;

import com.paf.exercise.model.Player;

public class AddPlayerRequestMapper {

    private AddPlayerRequestMapper() {
    }

    public static Player map(com.paf.exercise.requests.AddPlayerRequest addPlayerRequest) {
        return Player.builder()
                     .name(addPlayerRequest.name())
                     .build();
    }
}
