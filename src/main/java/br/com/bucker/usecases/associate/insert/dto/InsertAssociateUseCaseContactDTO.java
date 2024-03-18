package br.com.bucker.usecases.associate.insert.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

@Builder
@RegisterForReflection
public record InsertAssociateUseCaseContactDTO(
        String email,
        String phone
) {}
