package main.java.usecases;

import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecaseparameters.UseCaseParameter;

public class RemoveObjectUseCase extends AbstractUseCase<SingleObjectParameters> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public RemoveObjectUseCase(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return parameters instanceof SingleObjectParameters;
    }

    @Override
    protected UseCaseResult executeTyped(SingleObjectParameters parameters) {
        networkRepository.removeVertex(networkRepository.getVertexById(parameters.getVertexId()));
        return new ValidCommandResult();
    }
}
