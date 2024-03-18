package br.com.bucker.usecases.associate.findbyid;

import lombok.Getter;

public class FindByIdAssociateUseCaseException extends Exception {
    @Getter
    final String key;
    @Getter
    final String errors;

    public FindByIdAssociateUseCaseException(String key, String errors, String message) {
        super(message);
        this.key = key;
        this.errors = errors;
    }
}
