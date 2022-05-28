package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecases.MatLearnUseCase;

public interface UseCaseParameterAdapter {
    UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser);
}
