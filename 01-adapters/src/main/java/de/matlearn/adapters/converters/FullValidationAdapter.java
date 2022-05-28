package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.EmptyParameters;
import de.matlearn.application.usecases.MatLearnUseCase;

public class FullValidationAdapter implements UseCaseParameterAdapter{
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new EmptyParameters());
    }
}
