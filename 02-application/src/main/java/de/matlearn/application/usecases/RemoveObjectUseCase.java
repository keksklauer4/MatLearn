package de.matlearn.application.usecases;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.results.ValidCommandResult;
import de.matlearn.application.usecaseparameters.SingleObjectParameters;
import de.matlearn.domain.network.ProofNetworkRepository;

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
