package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.FindVertexResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.FindVertexParameter;

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