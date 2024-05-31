package com.paf.exercise.mapper;

import com.paf.exercise.entities.Tournament;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TournamentMapper {
    @InheritInverseConfiguration(name = "toDto")
    Tournament toEntity(com.paf.exercise.model.Tournament tournament);

    @InheritInverseConfiguration(name = "toDtos")
    List<Tournament> toEntities(List<com.paf.exercise.model.Tournament> tournaments);

    com.paf.exercise.model.Tournament toDto(Tournament tournament);
    List<com.paf.exercise.model.Tournament> toDtos(List<Tournament> tournaments);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tournament partialUpdate(com.paf.exercise.model.Tournament tournamentModel, @MappingTarget Tournament tournament);
}