package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.entities.NamedVertexFactory;
import main.java.network.ProofNetworkRepository;
import main.java.results.AddMatObjectResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecaseparameters.UseCaseParameter;


public class AddMathematicalObjectTask extends AbstractUseCase<AddMatObjectParameters> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public AddMathematicalObjectTask(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return parameters instanceof AddMatObjectParameters;
    }

    @Override
    protected UseCaseResult executeTyped(AddMatObjectParameters parameters) {
        NamedVertex vertex = NamedVertexFactory.create(parameters.getType(),
                parameters.getName(), parameters.getDescription());
        networkRepository.addVertex(vertex);
        return new AddMatObjectResult(vertex.getId());
    }
}
