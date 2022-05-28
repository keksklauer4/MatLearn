package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.helpers.ListLeaves;
import main.java.network.ProofNetworkRepository;
import main.java.results.FailedUseCaseResult;
import main.java.results.LeafListingResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

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
