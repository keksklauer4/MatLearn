package main.java.usecases;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.UseCaseParameter;

public interface MatLearnUseCase {
    UseCaseResult execute(UseCaseParameter parameter);
}
