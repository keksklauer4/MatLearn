package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.NeighborResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

import java.util.List;

public class ListNeighborsUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;

    public ListNeighborsUseCase(final SingleObjectParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        NamedVertex vertex = network.getVertexById(parameters.getVertexId());
        if (vertex == null) return null;
        List<NamedVertex> forward = network.getGraph().getForwardEdges(vertex);
        List<NamedVertex> backward = network.getGraph().getBackwardEdges(vertex);
        return new NeighborResult(backward, forward);
    }
}
