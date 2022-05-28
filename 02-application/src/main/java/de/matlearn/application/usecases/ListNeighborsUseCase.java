package de.matlearn.application.usecases;

import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.application.results.FailedUseCaseResult;
import de.matlearn.application.results.NeighborResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.SingleObjectParameters;

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
