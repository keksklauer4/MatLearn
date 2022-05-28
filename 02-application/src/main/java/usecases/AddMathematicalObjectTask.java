package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.entities.NamedVertexFactory;
import main.java.network.ProofNetworkRepository;
import main.java.results.AddMatObjectResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddMatObjectParameters;


public class AddMathematicalObjectTask extends AbstractUseCase<AddMatObjectParameters> implements MatLearnUseCase {
    public AddMathematicalObjectTask(ProofNetworkRepository networkRepository) {
        super(networkRepository, AddMatObjectParameters.class);
    }

    @Override
    protected UseCaseResult executeTyped(AddMatObjectParameters parameters) {
        NamedVertex vertex = NamedVertexFactory.create(parameters.getType(),
                parameters.getName(), parameters.getDescription());
        networkRepository.addVertex(vertex);
        return new AddMatObjectResult(vertex.getId());
    }
}
