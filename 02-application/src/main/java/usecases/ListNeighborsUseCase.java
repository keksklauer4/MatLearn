package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.NeighborResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

import java.util.List;

public class ListNeighborsUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;
    private final ProofNetworkRepository networkRepository;

    public ListNeighborsUseCase(SingleObjectParameters parameters, ProofNetworkRepository networkRepository) {
        this.parameters = parameters;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        NamedVertex vertex = networkRepository.getVertexById(parameters.getVertexId());
        if (vertex == null) return null;
        List<NamedVertex> forward = networkRepository.getGraph().getForwardEdges(vertex);
        List<NamedVertex> backward = networkRepository.getGraph().getBackwardEdges(vertex);
        return new NeighborResult(backward, forward);
    }
}
