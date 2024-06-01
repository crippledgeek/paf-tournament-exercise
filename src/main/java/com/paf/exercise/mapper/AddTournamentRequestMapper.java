package com.paf.exercise.mapper;

import com.paf.exercise.model.Tournament;

public class AddTournamentRequestMapper {

    private AddTournamentRequestMapper() {
    }

    public static com.paf.exercise.model.Tournament map(com.paf.exercise.requests.AddTournamentRequest addTournamentRequest) {
        return Tournament.builder()
                .name(addTournamentRequest.name())
                .rewardAmount(addTournamentRequest.reward())
                .build();
    }
}
