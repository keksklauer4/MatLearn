package main.java.commands;

import main.java.entities.MatType;
import main.java.parameters.IdListParameter;
import main.java.parameters.OptionParameter;
import main.java.parameters.Parameter;
import main.java.parameters.TextInputParameter;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AddDefinedObjectCommand implements GenericCommand{
    private final List<Parameter> parameters;

    public AddDefinedObjectCommand(){
        this.parameters = Arrays.asList(
                new OptionParameter(0, "Object type", "type",
                        new String[]{"Axiom", "Definition"},
                        new MatType[]{MatType.AXIOM, MatType.DEFINITION}),
                new TextInputParameter(1, "name", "name"),
                new TextInputParameter(2, "description", "desc"),
                new IdListParameter(3, "sources", "sources")
        );
    }

    @Override
    public List<Parameter> getParameters() {
        return this.parameters;
    }

    @Override
    public String getName() {
        return "Add definition or axiom";
    }

    @Override
    public String getHelpText() {
        return "Add a definition or an axiom, that is, a mathematical object without any dependencies.";
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
        return new AddMathematicalObjectTask(new AddMatObjectParameters(map));
    }
}
