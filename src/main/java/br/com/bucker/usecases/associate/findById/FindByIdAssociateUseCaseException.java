package br.com.bucker.usecases.associate.findById;

import lombok.Getter;

public class FindByIdAssociateUseCaseException extends Exception {
    @Getter
    String key;
    @Getter
    String errors;

    public FindByIdAssociateUseCaseException(String key, String errors, String message) {
        super(message);
        this.key = key;
        this.errors = errors;
    }
}
