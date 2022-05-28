package main.java.plugins;

import main.java.cli.CLIPrinter;
import main.java.exceptions.ValidationException;
import main.java.exceptions.ValidationExceptionHandler;
import main.java.exceptions.ValidationFunctor;

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
            printer.printLine(validationException.getMessage());
            return false;
        }
    }
}
