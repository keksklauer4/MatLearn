package main.java.usecases;

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
        List<Integer> fromIds = parameters.getVertexFromIds();
        List<Integer> toIds = parameters.getVertexToIds();
        if (fromIds == null || toIds == null) return null;
        for (Integer fromId : fromIds){
            if (fromId == null) continue;
            for (Integer toId : toIds){
                if (toId == null) continue;
                networkRepository.removeEdgeIfExists(fromId, toId);
            }
        }
        return new ValidCommandResult();
    }
}
