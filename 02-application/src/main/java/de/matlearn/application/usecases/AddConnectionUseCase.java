package de.matlearn.application.usecases;

import de.matlearn.application.results.FailedUseCaseResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.results.ValidCommandResult;
import de.matlearn.application.usecaseparameters.AddConnectionParameters;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkRepository;

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
            boolean validEdge = networkRepository.addEdge(from.get(), to.get());
            if (validEdge) return new ValidCommandResult();
        }
        return new FailedUseCaseResult();
    }
}
