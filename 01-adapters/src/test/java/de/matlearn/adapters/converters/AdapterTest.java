package de.matlearn.adapters.converters;

import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.application.usecases.MatLearnUseCase;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Map;

public abstract class AdapterTest<T extends MatLearnUseCase, P extends UseCaseParameter> {
    protected T useCase;
    private Class<T> useCaseType;
    private Class<P> parameterType;
    private P expectedParameters;

    public AdapterTest(Class<T> useCaseType, Class<P> parameterType) {
        this.useCaseType = useCaseType;
        this.parameterType = parameterType;
        useCase = Mockito.mock(useCaseType);
        Mockito.when(useCase.execute(Mockito.anyObject()))
                .then( obj -> {
                    Assertions.assertEquals(parameterType, obj.getClass());
                    if (parameterType.isInstance(obj)) assertCorrectObject((P) obj);
                    return null;
                });
    }


    protected void assertCorrectObject(final P parameters){
        Assertions.assertEquals(expectedParameters, parameters);
    }

    protected void setExpectedParameters(final P parameters){
        this.expectedParameters = parameters;
    }

    protected void runDispatcher(final Map<String, Object> parameterMap){
        UseCaseParameterDispatcher dispatcher = new UseCaseParameterDispatcher(useCase, parameterMap);
        dispatcher.dispatch();
    }

    protected void expectExceptionInDispatcher(final Map<String, Object> parameterMap){
        UseCaseParameterDispatcher dispatcher = new UseCaseParameterDispatcher(useCase, parameterMap);
        Assertions.assertThrows(RuntimeException.class, dispatcher::dispatch);
    }
}
