package main.java.commands;

import main.java.parameters.Parameter;
import main.java.validators.InvalidInputException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCommand implements GenericCommand {
    protected final List<Parameter> parameters;


    protected AbstractCommand(final List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public List<Parameter> getParameters() {
        return this.parameters;
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
    public Map<String, Object> getParameterMap() {
        HashMap<String, Object> parameterMap = new HashMap<>();
        try {
            for (final Parameter parameter : parameters) {
                parameterMap.put(parameter.getKey(), parameter.getParsedInput());
            }
        } catch (InvalidInputException e) {
            throw new RuntimeException(e.getMessage());
        }
        return parameterMap;
    }
}
