package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.FindVertexResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.FindVertexParameter;
import main.java.usecaseparameters.UseCaseParameter;

import java.util.List;
import java.util.stream.Collectors;

public class VertexFinder extends AbstractUseCase<FindVertexParameter> implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public VertexFinder(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return parameters instanceof FindVertexParameter;
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
