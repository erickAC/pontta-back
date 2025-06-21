package br.com.pontta.pontta.domains.exception;

public class CpfNaoValidoException extends RuntimeException {
    public CpfNaoValidoException(String message) {
        super(message);
    }
}
