package main.java.commands;

import main.java.parameters.Parameter;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

import java.util.List;

public class RemoveObjectCommand implements GenericCommand {

    @Override
    public List<Parameter> getParameters() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getHelpText() {
        return null;
    }

    @Override
    public void setInput(Parameter p, String input) throws InvalidInputException {

    }

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        return null;
    }
}
