package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.ExactlyOneIdParameter;
import de.matlearn.application.usecases.ListNeighborsUseCase;
import de.matlearn.application.usecases.MatLearnUseCase;

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
