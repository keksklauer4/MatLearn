package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.FailedUseCaseResult;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.AddConnectionParameters;

import java.util.Optional;

public class AddConnectionUseCase extends AbstractUseCase<AddConnectionParameters> implements MatLearnUseCase {
    public AddConnectionUseCase(ProofNetworkRepository networkRepository) {
        super(networkRepository, AddConnectionParameters.class);
    }

    @Override
    protected UseCaseResult executeTyped(AddConnectionParameters parameters) {
        Optional<NamedVertex> from = getVertexById(parameters.getVertexFromId());
        Optional<NamedVertex> to = getVertexById(parameters.getVertexToId());
        if (from.isPresent() && to.isPresent()){
            networkRepository.addEdge(from.get(), to.get());
            return new ValidCommandResult();
        }
        return new FailedUseCaseResult();
    }
}
