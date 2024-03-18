package br.com.bucker.usecases;

public interface BasicUseCase<IN,OUT,E extends Exception> {
    OUT execute(IN input) throws E;
}
