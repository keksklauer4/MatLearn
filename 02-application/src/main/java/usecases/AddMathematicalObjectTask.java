package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.entities.NamedVertexFactory;
import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.AddMatObjectResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddMatObjectParameters;


public class AddMathematicalObjectTask implements MatLearnUseCase {
    private final AddMatObjectParameters parameters;

    public AddMathematicalObjectTask(AddMatObjectParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        NamedVertex vertex = NamedVertexFactory.create(parameters.getType(),
                parameters.getName(), parameters.getDescription());
        network.addVertex(vertex);
        return new AddMatObjectResult(vertex.getId());
    }
}
