package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.helpers.ListLeaves;
import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.LeafListingResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

public class ListLeavesUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;

    public ListLeavesUseCase(final SingleObjectParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        NamedVertex vertex = network.getVertexById(parameters.getVertexId());
        if (vertex == null) return null;
        ListLeaves lister = new ListLeaves(network, vertex);
        return new LeafListingResult(lister.listLeaves());
    }
}
