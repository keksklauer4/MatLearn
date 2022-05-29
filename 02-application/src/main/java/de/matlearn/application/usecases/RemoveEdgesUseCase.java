package de.matlearn.application.usecases;

import de.matlearn.application.helpers.PairGenerator;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.results.ValidCommandResult;
import de.matlearn.application.usecaseparameters.RemoveEdgesParameters;
import de.matlearn.domain.network.ProofNetworkRepository;

public class RemoveEdgesUseCase extends AbstractUseCase<RemoveEdgesParameters> implements MatLearnUseCase {
    public RemoveEdgesUseCase(ProofNetworkRepository networkRepository) {
        super(networkRepository, RemoveEdgesParameters.class);
    }


    @Override
    protected UseCaseResult executeTyped(RemoveEdgesParameters parameters) {
        PairGenerator<Integer> pairGenerator = new PairGenerator<>(
                parameters.getVertexFromIds(),
                parameters.getVertexToIds());
        pairGenerator.generate(networkRepository::removeEdgeIfExists);

        return new ValidCommandResult();
    }
}
