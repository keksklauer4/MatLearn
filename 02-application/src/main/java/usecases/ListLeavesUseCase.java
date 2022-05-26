package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.helpers.ListLeaves;
import main.java.network.ProofNetworkRepository;
import main.java.results.LeafListingResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

public class ListLeavesUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;
    private final ProofNetworkRepository networkRepository;

    public ListLeavesUseCase(SingleObjectParameters parameters, ProofNetworkRepository networkRepository) {
        this.parameters = parameters;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        NamedVertex vertex = networkRepository.getVertexById(parameters.getVertexId());
        if (vertex == null) return null;
        ListLeaves lister = new ListLeaves(networkRepository, vertex);
        return new LeafListingResult(lister.listLeaves());
    }
}
