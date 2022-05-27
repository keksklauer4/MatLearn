package main.java.usecases;

import main.java.helpers.PairGenerator;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecaseparameters.UseCaseParameter;

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
