package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.IdListParameter;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.application.usecases.RemoveEdgesUseCase;

import java.util.Arrays;

public class RemoveEdgeCommand extends AbstractCommand {
    public RemoveEdgeCommand() {
        super(Arrays.asList(
                new IdListParameter(1, "From vertex ids", ParameterMapKeys.VERTEX_IDS_FROM_KEY),
                new IdListParameter(2, "To vertex ids", ParameterMapKeys.VERTEX_IDS_TO_KEY)
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
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new RemoveEdgesUseCase(networkRepository);
    }
}
