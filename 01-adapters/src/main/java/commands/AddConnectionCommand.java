package main.java.commands;

import main.java.converters.ParameterMapKeys;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecaseparameters.AddConnectionParameters;
import main.java.usecases.AddConnectionUseCase;
import main.java.usecases.MatLearnUseCase;

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
