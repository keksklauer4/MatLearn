package de.matlearn.application.usecases;

import de.matlearn.application.helpers.ListLeaves;
import de.matlearn.application.results.FailedUseCaseResult;
import de.matlearn.application.results.LeafListingResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.SingleObjectParameters;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.Optional;

public class ListLeavesUseCase extends AbstractUseCase<SingleObjectParameters> implements MatLearnUseCase {
    public ListLeavesUseCase(ProofNetworkRepository networkRepository) {
        super(networkRepository, SingleObjectParameters.class);
    }

    @Override
    protected UseCaseResult executeTyped(SingleObjectParameters parameters) {
        Optional<NamedVertex> vertex = getVertexById(parameters.getVertexId());
        if (vertex.isEmpty()) return new FailedUseCaseResult();
        ListLeaves lister = new ListLeaves(networkRepository, vertex.get());
        return new LeafListingResult(lister.listLeaves());
    }
}
