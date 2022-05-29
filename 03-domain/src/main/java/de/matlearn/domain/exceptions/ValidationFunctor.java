package de.matlearn.domain.exceptions;

public interface ValidationFunctor {
    void execute() throws ValidationException;
}
