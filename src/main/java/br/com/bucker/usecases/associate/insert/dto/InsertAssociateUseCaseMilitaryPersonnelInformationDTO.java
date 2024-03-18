package br.com.bucker.usecases.associate.insert.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@RegisterForReflection
public record InsertAssociateUseCaseMilitaryPersonnelInformationDTO(
        String trainingRegiment,
        LocalDate aspirantDate,
        String lastRank,
        String lastMilitaryOrganization
) {}
