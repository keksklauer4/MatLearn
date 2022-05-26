package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.AddConnectionParameters;

public class AddConnectionUseCase implements MatLearnUseCase {
    private final AddConnectionParameters parameters;
    private final ProofNetworkRepository networkRepository;

    public AddConnectionUseCase(AddConnectionParameters parameters, ProofNetworkRepository networkRepository) {
        this.parameters = parameters;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        NamedVertex from = networkRepository.getVertexById(parameters.getVertexFromId());
        NamedVertex to = networkRepository.getVertexById(parameters.getVertexToId());
        if (from != null && to != null){
            networkRepository.addEdge(from, to);
            return new ValidCommandResult();
        }
        return null;
    }
}
