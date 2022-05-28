package test.java.usecases;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.UseCaseParameter;
import main.java.usecases.MatLearnUseCase;
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
