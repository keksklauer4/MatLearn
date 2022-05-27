package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.NeighborResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecaseparameters.UseCaseParameter;

import java.util.List;

public class ListNeighborsUseCase extends AbstractUseCase<SingleObjectParameters> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public ListNeighborsUseCase(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return parameters instanceof SingleObjectParameters;
    }

    @Override
    protected UseCaseResult executeTyped(SingleObjectParameters parameters) {
        NamedVertex vertex = networkRepository.getVertexById(parameters.getVertexId());
        if (vertex == null) return null;
        List<NamedVertex> forward = networkRepository.getGraph().getForwardEdges(vertex);
        List<NamedVertex> backward = networkRepository.getGraph().getBackwardEdges(vertex);
        return new NeighborResult(backward, forward);
    }
}
