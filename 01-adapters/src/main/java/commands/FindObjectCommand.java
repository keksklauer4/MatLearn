package main.java.commands;

import main.java.parameters.Parameter;
import main.java.parameters.TextInputParameter;
import main.java.usecaseparameters.FindVertexParameter;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.VertexFinder;
import main.java.validators.InvalidInputException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindObjectCommand implements GenericCommand {
    private final List<Parameter> parameters;

    public FindObjectCommand() {
        this.parameters = Collections.singletonList(
                new TextInputParameter(1, "search", "search")
        );
    }

    @Override
    public List<Parameter> getParameters() {
        return this.parameters;
    }

    @Override
    public String getName() {
        return "Find object";
    }

    @Override
    public String getHelpText() {
        return "Find an object in the proof network given some search string.";
    }

    @Override
    public void setInput(final Parameter p, final String input) throws InvalidInputException {
        for (Parameter parameter : parameters){
            if (parameter.equals(p)){
                p.validateInput(input);
            }
        }
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        HashMap<String, Object> parameterMap = new HashMap<>();
        try {
            for (final Parameter parameter : parameters) {
                parameterMap.put(parameter.getKey(), parameter.getParsedInput());
            }
        } catch (InvalidInputException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new VertexFinder(new FindVertexParameter(parameterMap));
    }
}
