package main.java.usecases;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.UseCaseParameter;

public abstract class AbstractUseCase<T> implements MatLearnUseCase {
    @Override
    public UseCaseResult execute(UseCaseParameter parameters) {
        if (!checkCorrectParameterType(parameters))
            throw new RuntimeException("Invalid parameter type provided.");
        return executeTyped((T) parameters);
    }

    protected abstract boolean checkCorrectParameterType(UseCaseParameter parameters);
    protected abstract UseCaseResult executeTyped(T parameters);
}
