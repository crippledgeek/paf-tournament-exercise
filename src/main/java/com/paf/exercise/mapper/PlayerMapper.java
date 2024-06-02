package com.paf.exercise.mapper;

import com.paf.exercise.entities.Player;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TournamentMapper.class})
public interface PlayerMapper {
    @InheritInverseConfiguration(name = "toDto")
    Player toEntity(com.paf.exercise.model.Player player);
    @InheritInverseConfiguration(name = "toDtos")
    List<Player> toEntities(List<com.paf.exercise.model.Player> players);



    com.paf.exercise.model.Player toDto(Player player);
    List<com.paf.exercise.model.Player> toDtos(List<Player> players);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player partialUpdate(com.paf.exercise.model.Player playerModel, @MappingTarget Player player);
}