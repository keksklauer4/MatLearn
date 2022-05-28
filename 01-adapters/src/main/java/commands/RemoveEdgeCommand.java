package main.java.commands;

import main.java.converters.ParameterMapKeys;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.IdListParameter;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveEdgesUseCase;

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
