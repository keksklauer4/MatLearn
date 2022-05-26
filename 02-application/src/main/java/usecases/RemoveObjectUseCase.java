package main.java.usecases;

import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.SingleObjectParameters;

public class RemoveObjectUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;
    private final ProofNetworkRepository networkRepository;

    public RemoveObjectUseCase(SingleObjectParameters parameters, ProofNetworkRepository networkRepository) {
        this.parameters = parameters;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        networkRepository.removeVertex(networkRepository.getVertexById(parameters.getVertexId()));
        return new ValidCommandResult();
    }
}
