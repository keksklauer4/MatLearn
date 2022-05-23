package main.java.commands;

import main.java.commands.GenericCommand;
import main.java.entities.MatType;
import main.java.parameters.IdListParameter;
import main.java.parameters.Parameter;
import main.java.parameters.TextInputParameter;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AddTheoremCommand implements GenericCommand {
    private final List<Parameter> parameters;

    public AddTheoremCommand(){
        this.parameters = Arrays.asList(
                new TextInputParameter(0, "Name", "name"),
                new TextInputParameter(1, "Description", "desc"),
                new IdListParameter(2, "Dependencies", "deps"),
                new IdListParameter(3, "Sources", "sources")
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

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            for (final Parameter parameter : this.parameters) {
                map.put(parameter.getKey(), parameter.getParsedInput());
            }
        } catch (InvalidInputException e) {
            throw new RuntimeException(e.getMessage());
        }
        map.put("type", MatType.THEOREM);
        return new AddMathematicalObjectTask(new AddMatObjectParameters(map));
    }
}
