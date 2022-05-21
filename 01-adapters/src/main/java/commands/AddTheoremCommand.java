package main.java.commands;

import main.java.commands.GenericCommand;
import main.java.parameters.IdListParameter;
import main.java.parameters.Parameter;
import main.java.parameters.TextInputParameter;
import main.java.validators.InvalidInputException;

import java.util.Arrays;
import java.util.List;

public class AddTheoremCommand implements GenericCommand {
    private final List<Parameter> parameters;

    public AddTheoremCommand(){
        this.parameters = Arrays.asList(
                new TextInputParameter(0, "Name"),
                new TextInputParameter(1, "Description"),
                new IdListParameter(2, "Dependencies"),
                new IdListParameter(3, "Sources")
        );
    }

    @Override
    public List<Parameter> getParameters() {
        return this.parameters;
    }

    @Override
    public String getName() {
        return "Add a theorem";
    }

    @Override
    public String getHelpText() {
        return "Add a theorem which depends on a set of other mathematical objects";
    }


    @Override
    public void setInput(Parameter p, String input) throws InvalidInputException {
        for (Parameter parameter : parameters){
            if (parameter.equals(p)){
                parameter.validateInput(input);
                return;
            }
        }
        throw new RuntimeException("Invalid parameter supplied!");
    }
}
