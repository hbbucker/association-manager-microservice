package br.com.bucker.usecases;

public interface BasicUseCase<I, O, E extends Exception> {
    O execute(I input) throws E;
}
