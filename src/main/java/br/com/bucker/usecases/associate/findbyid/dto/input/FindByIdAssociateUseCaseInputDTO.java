package br.com.bucker.usecases.associate.findbyid.dto.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@RegisterForReflection
public record FindByIdAssociateUseCaseInputDTO (UUID id){
}
