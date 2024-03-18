package br.com.bucker.adpters.rest.dto.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@RegisterForReflection
public record AssociateRestInputDTO(
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


