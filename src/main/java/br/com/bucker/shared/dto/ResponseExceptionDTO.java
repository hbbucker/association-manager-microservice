package br.com.bucker.shared.dto;

import lombok.Builder;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

@Builder
public record ResponseExceptionDTO(
        String key,
        String message,
        ResponseErrorsDomainExceptionDTO[] errors) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseExceptionDTO that = (ResponseExceptionDTO) o;
        return Objects.equals(key, that.key) && Objects.equals(message, that.message) && Arrays.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(key, message);
        result = 31 * result + Arrays.hashCode(errors);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseExceptionDTO{" +
                "key='" + key + '\'' +
                ", message='" + message + '\'' +
                ", errors=" + Arrays.toString(errors) +
                '}';
    }
}
