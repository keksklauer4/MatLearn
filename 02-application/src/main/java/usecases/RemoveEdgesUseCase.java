package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.RemoveEdgesParameters;

import java.util.List;

public class RemoveEdgesUseCase implements MatLearnUseCase {
    private final RemoveEdgesParameters parameters;

    public RemoveEdgesUseCase(final RemoveEdgesParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        List<Integer> fromIds = parameters.getVertexFromIds();
        List<Integer> toIds = parameters.getVertexToIds();
        if (fromIds == null || toIds == null) return null;
        for (Integer fromId : fromIds){
            if (fromId == null) continue;
            for (Integer toId : toIds){
                if (toId == null) continue;
                network.removeEdgeIfExists(fromId, toId);
            }
        }
        return new ValidCommandResult();
    }
}
