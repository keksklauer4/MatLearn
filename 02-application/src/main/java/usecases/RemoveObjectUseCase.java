package main.java.usecases;

import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.SingleObjectParameters;

public class RemoveObjectUseCase extends AbstractUseCase<SingleObjectParameters> implements MatLearnUseCase {
    public RemoveObjectUseCase(ProofNetworkRepository networkRepository) {
        super(networkRepository, SingleObjectParameters.class);
    }


    @Override
    protected UseCaseResult executeTyped(SingleObjectParameters parameters) {
        networkRepository.removeVertex(networkRepository.getVertexById(parameters.getVertexId()));
        return new ValidCommandResult();
    }
}
