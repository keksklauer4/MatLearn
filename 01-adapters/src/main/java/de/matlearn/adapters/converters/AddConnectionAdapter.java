package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.AddConnectionParameters;
import de.matlearn.application.usecases.MatLearnUseCase;

public class AddConnectionAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new AddConnectionParameters(
                parser.parseInteger(ParameterMapKeys.FROM_VERTEX_KEY),
                parser.parseInteger(ParameterMapKeys.TO_VERTEX_KEY))
        );
    }
}
