package main.java.commands;

import main.java.parameters.ExactlyOneIdParameter;
import main.java.parameters.Parameter;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeavesCommand implements GenericCommand {
    private final List<Parameter> parameters;

    public LeavesCommand(){
        this.parameters = Collections.singletonList(
                new ExactlyOneIdParameter(1, "Search id", "vertexId")
        );
    }

    @Override
    public List<Parameter> getParameters() {
        return this.parameters;
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
