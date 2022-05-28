package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.SingleObjectParameters;
import de.matlearn.application.usecases.MatLearnUseCase;

public class RemoveObjectAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new SingleObjectParameters(
                parser.parseInteger(ParameterMapKeys.VERTEX_ID_KEY)));
    }
}
