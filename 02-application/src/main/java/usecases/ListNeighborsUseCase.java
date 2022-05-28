package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.FailedUseCaseResult;
import main.java.results.NeighborResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

import java.util.List;
import java.util.Optional;

public class ListNeighborsUseCase extends AbstractUseCase<SingleObjectParameters> implements MatLearnUseCase {
    public ListNeighborsUseCase(ProofNetworkRepository networkRepository) {
        super(networkRepository, SingleObjectParameters.class);
    }

    @Override
    protected UseCaseResult executeTyped(SingleObjectParameters parameters) {
        Optional<NamedVertex> vertex = getVertexById(parameters.getVertexId());
        if (vertex.isEmpty()) return new FailedUseCaseResult();
        List<NamedVertex> forward = networkRepository.getGraph().getForwardEdges(vertex.get());
        List<NamedVertex> backward = networkRepository.getGraph().getBackwardEdges(vertex.get());
        return new NeighborResult(backward, forward);
    }
}
