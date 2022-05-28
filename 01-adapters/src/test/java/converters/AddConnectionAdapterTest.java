package test.java.converters;

import main.java.converters.ParameterMapKeys;
import main.java.usecaseparameters.AddConnectionParameters;
import main.java.usecases.AddConnectionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AddConnectionAdapterTest extends AdapterTest<AddConnectionUseCase, AddConnectionParameters> {
    public AddConnectionAdapterTest() {
        super(AddConnectionUseCase.class, AddConnectionParameters.class);
    }

    @Test
    void test_ValidAddConnection(){
        setExpectedParameters(new AddConnectionParameters(10, 11));
        runDispatcher(Map.of(
                ParameterMapKeys.FROM_VERTEX_KEY, 10,
                ParameterMapKeys.TO_VERTEX_KEY, 11
        ));
    }

    @Test
    void test_InvalidAddConnection(){
        setExpectedParameters(new AddConnectionParameters(-1, -1));
        expectExceptionInDispatcher(Map.of(
                ParameterMapKeys.FROM_VERTEX_KEY, 10
        ));
    }
}
