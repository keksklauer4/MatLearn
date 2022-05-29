package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.adapters.parameters.ExactlyOneIdParameter;
import de.matlearn.application.usecases.AddConnectionUseCase;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.Arrays;

public class AddConnectionCommand extends AbstractCommand {
    public AddConnectionCommand() {
        super(Arrays.asList(
                new ExactlyOneIdParameter(1, "Edge from", ParameterMapKeys.FROM_VERTEX_KEY),
                new ExactlyOneIdParameter(2, "Edge to", ParameterMapKeys.TO_VERTEX_KEY)
        ));
    }

    @Override
    public String getName() {
        return "Connect two objects";
    }

    @Override
    public String getHelpText() {
        return "Connect two mathematical objects through an edge given the ids of the objects.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new AddConnectionUseCase(networkRepository);
    }
}
