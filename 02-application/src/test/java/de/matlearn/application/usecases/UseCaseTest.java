package de.matlearn.application.usecases;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import org.junit.jupiter.api.Assertions;

public abstract class UseCaseTest <R extends UseCaseResult>  {
    private final Class<R> resultType;

    public UseCaseTest(Class<R> resultType) {
        this.resultType = resultType;
    }

    protected R assertCorrectType(MatLearnUseCase useCase, UseCaseParameter parameter){
        UseCaseResult result = useCase.execute(parameter);
        Assertions.assertEquals(resultType, result.getClass());
        return (R) result;
    }

    protected void assertThrow(MatLearnUseCase useCase, UseCaseParameter wrongParameter,
                               Class<? extends Throwable> expectedException){
        Assertions.assertThrows(expectedException, () -> useCase.execute(wrongParameter));
    }
}
