package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.application.usecases.MatLearnUseCase;

public class MatLearnUseCaseMock implements MatLearnUseCase {
    private final UseCaseAssertionFunctor functor;

    public MatLearnUseCaseMock(UseCaseAssertionFunctor functor) {
        this.functor = functor;
    }

    @Override
    public UseCaseResult execute(UseCaseParameter parameter) {
        functor.execute(parameter);
        return null;
    }
}
