package main.java.commands;

import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveObjectUseCase;

import java.util.Collections;

public class RemoveObjectCommand extends AbstractCommand {
    public RemoveObjectCommand() {
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Object id", "vertexId")
        ));
    }

    @Override
    public String getName() {
        return "Remove object";
    }

    @Override
    public String getHelpText() {
        return "Remove a mathematical object given the its id.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        return new RemoveObjectUseCase(new SingleObjectParameters(getParameterMap()));
    }
}