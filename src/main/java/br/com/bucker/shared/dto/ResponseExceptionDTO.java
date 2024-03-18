package br.com.bucker.shared.dto;

import lombok.Builder;

import java.util.Map;

@Builder
public record ResponseExceptionDTO(
        String key,
        String message,
        ResponseErrorsDomainExceptionDTO[] errors) {
}
