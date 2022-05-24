package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.AddConnectionParameters;

public class AddConnectionUseCase implements MatLearnUseCase {
    private final AddConnectionParameters parameters;

    public AddConnectionUseCase(final AddConnectionParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        NamedVertex from = network.getVertexById(parameters.getVertexFromId());
        NamedVertex to = network.getVertexById(parameters.getVertexToId());
        if (from != null && to != null){
            network.addEdge(from, to);
            return new ValidCommandResult();
        }
        return null;
    }
}
