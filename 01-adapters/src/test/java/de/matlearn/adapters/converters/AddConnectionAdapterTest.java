package de.matlearn.adapters.converters;

import de.matlearn.application.usecaseparameters.AddConnectionParameters;
import de.matlearn.application.usecases.AddConnectionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

public class AddConnectionAdapterTest extends AdapterTest<AddConnectionParameters> {
    public AddConnectionAdapterTest() {
        super(AddConnectionParameters.class);
    }

    @Test
    void test_ValidAddConnection(){
        setExpectedParameters(new AddConnectionParameters(10, 11));
        setUseCase(new MatLearnUseCaseMock(this::assertCorrectObject));
        AddConnectionAdapter addConnectionAdapter = new AddConnectionAdapter();
        addConnectionAdapter.executeUseCase(useCase, new ParameterMapParser(Map.of(
                ParameterMapKeys.FROM_VERTEX_KEY, 10,
                ParameterMapKeys.TO_VERTEX_KEY, 11
        )));
    }

    @Test
    void test_InvalidAddConnection(){
        setUseCase(new MatLearnUseCaseMock(this::assertCorrectObject));
        setExpectedParameters(new AddConnectionParameters(-1, -1));
        AddConnectionAdapter addConnectionAdapter = new AddConnectionAdapter();
        Assertions.assertThrows(RuntimeException.class,
                () -> addConnectionAdapter.executeUseCase(useCase, new ParameterMapParser((Map.of(
                        ParameterMapKeys.FROM_VERTEX_KEY, 10)
        ))));
    }
}
