package de.matlearn.application.usecases;

import de.matlearn.application.results.AddMatObjectResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.AddMatObjectParameters;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.entities.NamedVertexFactory;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.Optional;


public class AddMathematicalObjectTask extends AbstractUseCase<AddMatObjectParameters> implements MatLearnUseCase {
    public AddMathematicalObjectTask(ProofNetworkRepository networkRepository) {
        super(networkRepository, AddMatObjectParameters.class);
    }

    @Override
    protected UseCaseResult executeTyped(AddMatObjectParameters parameters) {
        NamedVertex vertex = NamedVertexFactory.create(parameters.getType(),
                parameters.getName(), parameters.getDescription());
        networkRepository.addVertex(vertex);
        parameters.getDependencies().forEach(id -> {
            Optional<NamedVertex> dependency = getVertexById(id);
            dependency.ifPresent(namedVertex -> networkRepository.addEdge(namedVertex, vertex));
        });
        parameters.getSources().forEach(id -> {
            Optional<NamedVertex> contribution = getVertexById(id);
            contribution.ifPresent(namedVertex -> networkRepository.addEdge(vertex, namedVertex));
        });
        return new AddMatObjectResult(vertex.getId());
    }
}
