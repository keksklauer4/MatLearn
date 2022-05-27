package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecases.MatLearnUseCase;

import java.util.Map;

public interface UseCaseParameterAdapter {
    UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap);
}
