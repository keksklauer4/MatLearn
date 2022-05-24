package main.java.commands;

import main.java.parameters.IdListParameter;
import main.java.usecases.MatLearnUseCase;

import java.util.Arrays;

public class RemoveEdgeCommand extends AbstractCommand {
    public RemoveEdgeCommand() {
        super(Arrays.asList(
                new IdListParameter(1, "From vertex ids", "vertexIdsFrom"),
                new IdListParameter(2, "To vertex ids", "vertexIdsTo")
        ));
    }

    @Override
    public String getName() {
        return "Remove connections";
    }

    @Override
    public String getHelpText() {
        return "Remove all connections for pairs of object ids.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        return null;
    }
}
