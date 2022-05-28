package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.EmptyParameters;
import main.java.usecases.MatLearnUseCase;

public class FullValidationAdapter implements UseCaseParameterAdapter{
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new EmptyParameters());
    }
}
