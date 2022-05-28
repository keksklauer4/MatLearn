package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecases.MatLearnUseCase;

public interface UseCaseParameterAdapter {
    UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser);
}
