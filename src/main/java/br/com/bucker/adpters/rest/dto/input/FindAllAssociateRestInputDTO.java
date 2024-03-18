package br.com.bucker.adpters.rest.dto.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

@Builder
@RegisterForReflection
public record FindAllAssociateRestInputDTO(
        Integer page,
        Integer pageSize,
        String sort,

        String name,
        String cpf,
        String city,
        String state,
        String country
) {
}
