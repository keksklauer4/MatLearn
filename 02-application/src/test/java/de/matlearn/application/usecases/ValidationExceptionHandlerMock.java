package de.matlearn.application.usecases;

import de.matlearn.domain.exceptions.NoObjectValidationException;
import de.matlearn.domain.exceptions.ValidationException;
import de.matlearn.domain.exceptions.ValidationExceptionHandler;
import de.matlearn.domain.exceptions.ValidationFunctor;
import org.junit.jupiter.api.Assertions;

public class ValidationExceptionHandlerMock implements ValidationExceptionHandler {
    @Override
    public boolean handle(ValidationFunctor functor) {
        try {
            functor.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void handle(ValidationException exception) {

    }
}
