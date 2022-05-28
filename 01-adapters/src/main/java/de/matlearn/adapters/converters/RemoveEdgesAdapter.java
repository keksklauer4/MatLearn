package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.RemoveEdgesParameters;
import de.matlearn.application.usecases.MatLearnUseCase;

public class RemoveEdgesAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new RemoveEdgesParameters(
                parser.parseIntegerList(ParameterMapKeys.VERTEX_IDS_FROM_KEY),
                parser.parseIntegerList(ParameterMapKeys.VERTEX_IDS_TO_KEY))
        );
    }
}
