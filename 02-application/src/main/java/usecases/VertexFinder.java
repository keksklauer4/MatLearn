package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.network.ProofNetwork;
import main.java.network.ProofNetworkRepository;
import main.java.results.FindVertexResult;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.FindVertexParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VertexFinder implements MatLearnUseCase {
    private final FindVertexParameter parameter;

    public VertexFinder(FindVertexParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public UseCaseResult execute() {
        ProofNetworkRepository network = ProofNetwork.getInstance();
        List<NamedVertex> vertices = network.getVertices()
                .stream()
                .filter(parameter::matchesSearch)
                .collect(Collectors.toList());
        return new FindVertexResult(parameter.getSearch(), vertices);
    }
}
