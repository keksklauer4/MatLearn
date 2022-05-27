package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.AddConnectionParameters;
import main.java.usecaseparameters.UseCaseParameter;

public class AddConnectionUseCase extends AbstractUseCase<AddConnectionParameters> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public AddConnectionUseCase(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return parameters instanceof AddConnectionParameters;
    }

    @Override
    protected UseCaseResult executeTyped(AddConnectionParameters parameters) {
        NamedVertex from = networkRepository.getVertexById(parameters.getVertexFromId());
        NamedVertex to = networkRepository.getVertexById(parameters.getVertexToId());
        if (from != null && to != null){
            networkRepository.addEdge(from, to);
            return new ValidCommandResult();
        }
        return null;
    }
}
