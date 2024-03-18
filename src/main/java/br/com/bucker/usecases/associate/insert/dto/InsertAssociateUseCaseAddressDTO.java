package br.com.bucker.usecases.associate.insert.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

@Builder
@RegisterForReflection
public record InsertAssociateUseCaseAddressDTO(
        String street,
        String number,
        String complement,
        String city,
        String state,
        String zipCode,
        String country
) {}
