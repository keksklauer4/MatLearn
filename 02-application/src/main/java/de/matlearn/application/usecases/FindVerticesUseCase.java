package de.matlearn.application.usecases;

import de.matlearn.application.results.FindVertexResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.FindVertexParameter;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FindVerticesUseCase extends AbstractUseCase<FindVertexParameter> implements MatLearnUseCase {

    public FindVerticesUseCase(ProofNetworkRepository networkRepository) {
        super(networkRepository, FindVertexParameter.class);
    }

    @Override
    protected UseCaseResult executeTyped(FindVertexParameter parameters) {
        List<NamedVertex> vertices = networkRepository.getVertices()
                .stream()
                .filter(parameters::matchesSearch)
                .collect(Collectors.toList());
        return new FindVertexResult(parameters.getSearch(), vertices);
    }
}
