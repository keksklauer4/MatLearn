package main.java.commands;

import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecases.MatLearnUseCase;

import java.util.Arrays;

public class AddConnectionCommand extends AbstractCommand {
    public AddConnectionCommand() {
        super(Arrays.asList(
                new ExactlyOneIdParameter(1, "Edge from", "fromVertex"),
                new ExactlyOneIdParameter(2, "Edge to", "toVertex")
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
