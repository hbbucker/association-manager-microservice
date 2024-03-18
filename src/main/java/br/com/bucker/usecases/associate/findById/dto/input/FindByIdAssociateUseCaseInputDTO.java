package br.com.bucker.usecases.associate.findById.dto.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@RegisterForReflection
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public record FindByIdAssociateUseCaseInputDTO (UUID id){
}
