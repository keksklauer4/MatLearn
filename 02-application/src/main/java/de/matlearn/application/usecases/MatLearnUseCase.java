package de.matlearn.application.usecases;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;

public interface MatLearnUseCase {
    UseCaseResult execute(UseCaseParameter parameter);
}
