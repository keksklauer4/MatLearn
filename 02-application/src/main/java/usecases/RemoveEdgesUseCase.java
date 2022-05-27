package main.java.usecases;

import main.java.helpers.PairGenerator;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.RemoveEdgesParameters;

import java.util.List;

public class RemoveEdgesUseCase implements MatLearnUseCase {
    private final RemoveEdgesParameters parameters;
    private final ProofNetworkRepository networkRepository;

    public RemoveEdgesUseCase(RemoveEdgesParameters parameters, ProofNetworkRepository networkRepository) {
        this.parameters = parameters;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        PairGenerator<Integer> pairGenerator = new PairGenerator<>(
                parameters.getVertexFromIds(),
                parameters.getVertexToIds());
        pairGenerator.generate(networkRepository::removeEdgeIfExists);

        return new ValidCommandResult();
    }
}
