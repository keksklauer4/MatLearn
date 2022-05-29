package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.application.usecases.MatLearnUseCase;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Map;

public abstract class AdapterTest<P extends UseCaseParameter> {
    protected MatLearnUseCase useCase;
    private Class<P> parameterType;
    private P expectedParameters;

    public AdapterTest(Class<P> parameterType) {
        this.parameterType = parameterType;
    }

    public void setUseCase(MatLearnUseCase useCase) {
        this.useCase = useCase;
    }

    protected void assertCorrectObject(final UseCaseParameter parameters){
        Assertions.assertEquals(parameterType, parameters.getClass());
        Assertions.assertEquals(expectedParameters, parameters);
    }

    protected void setExpectedParameters(final P parameters){
        this.expectedParameters = parameters;
    }

}
