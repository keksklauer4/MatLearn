package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveEdgesUseCase;

import java.util.Map;

public class RemoveEdgesAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new RemoveEdgesParameters(
                parser.parseIntegerList("vertexIdsFrom"),
                parser.parseIntegerList("vertexIdsTo"))
        );
    }
}
