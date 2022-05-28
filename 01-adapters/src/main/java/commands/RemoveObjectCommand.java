package main.java.commands;

import main.java.converters.ParameterMapKeys;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveObjectUseCase;

import java.util.Collections;

public class RemoveObjectCommand extends AbstractCommand {
    public RemoveObjectCommand() {
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Object id", ParameterMapKeys.VERTEX_ID_KEY)
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
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new RemoveObjectUseCase(networkRepository);
    }
}
