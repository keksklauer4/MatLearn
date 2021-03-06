package de.matlearn.plugins.plugins;

import de.matlearn.domain.exceptions.ValidationException;
import de.matlearn.domain.exceptions.ValidationExceptionHandler;
import de.matlearn.domain.exceptions.ValidationFunctor;
import de.matlearn.plugins.cli.CLIPrinter;

public class ValidationExceptionHandlerImpl implements ValidationExceptionHandler {
    private final CLIPrinter printer;

    public ValidationExceptionHandlerImpl(CLIPrinter printer) {
        this.printer = printer;
    }

    @Override
    public boolean handle(ValidationFunctor functor) {
        try {
            functor.execute();
            return true;
        } catch (ValidationException validationException){
            handle(validationException);
            return false;
        }
    }

    @Override
    public void handle(ValidationException exception) {
        printer.printLine("Validation error: " + exception.getMessage());
    }
}
