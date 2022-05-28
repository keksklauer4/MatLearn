package main.java.exceptions;

public interface ValidationExceptionHandler {
    boolean handle(ValidationFunctor functor);
    void handle(ValidationException exception);
}
