package br.com.bucker.adpters.rest.dto.output;

import io.quarkus.resteasy.reactive.links.RestLinkId;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@RegisterForReflection
public record AssociateRestOutputDTO(

        @RestLinkId
        UUID id,
        String name,
        PersonalDocument documents,
        MilitaryPersonnelInformation militaryPersonnelInformation,
        List<Contact> contacts,
        Address address,
        LocalDate birthDate
) {
    @Builder
    public record PersonalDocument(
            String cpf,
            String rg,
            String rgOrgExpeditor) {
    }

    @Builder
    public record MilitaryPersonnelInformation(
            String trainingRegiment,
            LocalDate aspirantDate,
            String lastRank,
            String lastMilitaryOrganization) {
    }

    @Builder
    public record Address(
            String street,
            String number,
            String complement,
            String city,
            String state,
            String zipCode,
            String country) {
    }

    @Builder
    public record Contact(String phone, String email) {
    }
}


