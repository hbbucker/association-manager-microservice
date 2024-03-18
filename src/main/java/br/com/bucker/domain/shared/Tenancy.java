package br.com.bucker.domain.shared;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@RegisterForReflection
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Tenancy {
    Long id = 1L;
}
