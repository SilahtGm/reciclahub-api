package br.com.reciclahub.exception;

public class ArmazenamentoNotFoundException extends RuntimeException {
    public ArmazenamentoNotFoundException(String message) {
        super(message);
    }
}
