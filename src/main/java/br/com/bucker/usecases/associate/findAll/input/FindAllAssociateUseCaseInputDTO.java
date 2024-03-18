package br.com.bucker.usecases.associate.findAll.input;

import io.quarkus.runtime.annotations.RegisterForReflection;

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
