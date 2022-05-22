package main.java.commands;

import main.java.parameters.Parameter;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

import java.util.List;

public interface GenericCommand {
    List<Parameter> getParameters();
    String getName();
    String getHelpText();
    void setInput(final Parameter p, String input) throws InvalidInputException;
    MatLearnUseCase getParametrizedUseCase();
}
