package de.matlearn.domain.exceptions;

public interface ValidationExceptionHandler {
    boolean handle(ValidationFunctor functor);
    void handle(ValidationException exception);
}
