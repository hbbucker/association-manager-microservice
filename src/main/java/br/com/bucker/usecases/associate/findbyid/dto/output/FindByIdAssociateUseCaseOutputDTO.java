package br.com.bucker.usecases.associate.findbyid.dto.output;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@RegisterForReflection
public record FindByIdAssociateUseCaseOutputDTO(
        UUID id,
        String name,
        PersonalDocument documents,
        MilitaryPersonnelInformation militaryPersonnelInformation,
        List<Contact> contacts,
        Address address,
        LocalDate birthDate
) {
    @Builder
    @RegisterForReflection
    public record PersonalDocument(
            String cpf,
            String rg,
            String rgOrgExpeditor) {
    }

    @Builder
    @RegisterForReflection
    public record MilitaryPersonnelInformation(
            String trainingRegiment,
            LocalDate aspirantDate,
            String lastRank,
            String lastMilitaryOrganization) {
    }

    @Builder
    @RegisterForReflection
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
    @RegisterForReflection
    public record Contact(String phone, String email) {
    }
}
