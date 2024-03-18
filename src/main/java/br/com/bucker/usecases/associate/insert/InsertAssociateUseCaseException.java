package br.com.bucker.usecases.associate.insert;

import lombok.Getter;

@Getter
public class InsertAssociateUseCaseException extends Exception {
    final String key;
    final String errors;

    public InsertAssociateUseCaseException(String key, String errors, String message) {
        super(message);
        this.key = key;
        this.errors = errors;
    }
}
