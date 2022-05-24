package main.java.commands;

import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecases.MatLearnUseCase;

import java.util.Collections;

public class ObjectNeighborhoodCommand extends AbstractCommand {
    public ObjectNeighborhoodCommand() {
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Search id", "vertexId")
        ));
    }

    @Override
    public String getName() {
        return "Object neighborhood.";
    }

    @Override
    public String getHelpText() {
        return "List all neighbors of a mathematical object.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        return null;
    }
}
