package de.matlearn.domain.exceptions;

public class NoObjectValidationException extends ValidationException {
    public NoObjectValidationException() {
        super("No object found.");
    }
}
