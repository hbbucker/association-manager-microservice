package br.com.bucker.domain.shared;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@RegisterForReflection
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Notification {
    String domain;
    String message;

    @Override
    public String toString() {
        return "%s:%s".formatted(domain, message);
    }
}
