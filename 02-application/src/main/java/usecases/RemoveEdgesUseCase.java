package main.java.usecases;

import main.java.helpers.PairGenerator;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecaseparameters.UseCaseParameter;

public class RemoveEdgesUseCase extends AbstractUseCase<RemoveEdgesParameters> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public RemoveEdgesUseCase(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return parameters instanceof RemoveEdgesParameters;
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
