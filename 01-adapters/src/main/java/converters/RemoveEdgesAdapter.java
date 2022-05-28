package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecases.MatLearnUseCase;

public class RemoveEdgesAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new RemoveEdgesParameters(
                parser.parseIntegerList(ParameterMapKeys.VERTEX_IDS_FROM_KEY),
                parser.parseIntegerList(ParameterMapKeys.VERTEX_IDS_TO_KEY))
        );
    }
}
