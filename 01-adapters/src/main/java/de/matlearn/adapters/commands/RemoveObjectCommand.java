package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.adapters.parameters.ExactlyOneIdParameter;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.application.usecases.RemoveObjectUseCase;
import de.matlearn.domain.network.ProofNetworkRepository;

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
