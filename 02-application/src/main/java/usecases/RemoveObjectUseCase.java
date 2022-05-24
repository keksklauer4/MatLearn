package main.java.usecases;

import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.SingleObjectParameters;

public class RemoveObjectUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;

    public RemoveObjectUseCase(final SingleObjectParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        network.removeVertex(network.getVertexById(parameters.getVertexId()));
        return new ValidCommandResult();
    }
}
