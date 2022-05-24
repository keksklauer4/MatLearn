package main.java.commands;

import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecases.MatLearnUseCase;

import java.util.Arrays;

public class RemoveObjectCommand extends AbstractCommand {
    public RemoveObjectCommand() {
        super(Arrays.asList(
                new ExactlyOneIdParameter(1, "Object id", "vertexId")
        ));
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
    public MatLearnUseCase getParametrizedUseCase() {
        return null;
    }
}
