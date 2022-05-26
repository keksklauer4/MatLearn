package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.entities.NamedVertexFactory;
import main.java.network.ProofNetworkRepository;
import main.java.results.AddMatObjectResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddMatObjectParameters;


public class AddMathematicalObjectTask implements MatLearnUseCase {
    private final AddMatObjectParameters parameters;
    private final ProofNetworkRepository networkRepository;

    public AddMathematicalObjectTask(AddMatObjectParameters parameters, ProofNetworkRepository networkRepository) {
        this.parameters = parameters;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        NamedVertex vertex = NamedVertexFactory.create(parameters.getType(),
                parameters.getName(), parameters.getDescription());
        networkRepository.addVertex(vertex);
        return new AddMatObjectResult(vertex.getId());
    }
}
