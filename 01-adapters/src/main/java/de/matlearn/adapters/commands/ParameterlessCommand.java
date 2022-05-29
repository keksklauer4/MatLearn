package de.matlearn.adapters.commands;

import de.matlearn.adapters.parameters.Parameter;
import de.matlearn.adapters.validators.InvalidInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ParameterlessCommand implements GenericCommand {
    @Override
    public List<Parameter> getParameters() {
        return new ArrayList<>();
    }

    @Override
    public void setInput(Parameter p, String input) throws InvalidInputException { }

    @Override
    public Map<String, Object> getParameterMap() {
        return new HashMap<>();
    }
}
