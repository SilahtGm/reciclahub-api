package br.com.reciclahub.exception;

public class ColetaNotFoundException extends RuntimeException {
    public ColetaNotFoundException(String message) {
        super(message);
    }
}
