package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.results.FindVertexResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.FindVertexParameter;

import java.util.List;
import java.util.stream.Collectors;

public class VertexFinder implements MatLearnUseCase {
    private final FindVertexParameter parameter;
    private final ProofNetworkRepository networkRepository;

    public VertexFinder(FindVertexParameter parameter, ProofNetworkRepository networkRepository) {
        this.parameter = parameter;
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute() {
        List<NamedVertex> vertices = networkRepository.getVertices()
                .stream()
                .filter(parameter::matchesSearch)
                .collect(Collectors.toList());
        return new FindVertexResult(parameter.getSearch(), vertices);
    }
}
