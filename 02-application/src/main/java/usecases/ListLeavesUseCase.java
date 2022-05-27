package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.helpers.ListLeaves;
import main.java.network.ProofNetworkRepository;
import main.java.results.LeafListingResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecaseparameters.UseCaseParameter;

public class ListLeavesUseCase extends AbstractUseCase<SingleObjectParameters> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public ListLeavesUseCase(ProofNetworkRepository networkRepository) {
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
        ListLeaves lister = new ListLeaves(networkRepository, vertex);
        return new LeafListingResult(lister.listLeaves());
    }
}
