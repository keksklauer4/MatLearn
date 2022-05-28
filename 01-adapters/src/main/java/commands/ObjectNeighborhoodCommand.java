package main.java.commands;

import main.java.converters.ParameterMapKeys;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecases.ListNeighborsUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.Collections;

public class ObjectNeighborhoodCommand extends AbstractCommand {
    public ObjectNeighborhoodCommand() {
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Search id", ParameterMapKeys.VERTEX_ID_KEY)
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
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new ListNeighborsUseCase(networkRepository);
    }
}
