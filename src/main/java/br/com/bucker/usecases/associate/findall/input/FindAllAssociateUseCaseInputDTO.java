package br.com.bucker.usecases.associate.findall.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

@Builder
@RegisterForReflection
public record FindAllAssociateUseCaseInputDTO (
    Integer page,
    Integer pageSize,
    String sort,

    String name,
    String cpf,
    String city,
    String state,
    String country
){ }
