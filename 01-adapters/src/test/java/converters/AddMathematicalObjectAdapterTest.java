package test.java.converters;

import main.java.converters.ParameterMapKeys;
import main.java.entities.MatType;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AddMathematicalObjectAdapterTest extends AdapterTest<AddMathematicalObjectTask, AddMatObjectParameters> {
    public AddMathematicalObjectAdapterTest() {
        super(AddMathematicalObjectTask.class, AddMatObjectParameters.class);
    }

    @Test
    void test_ValidAddMatObject(){
        setExpectedParameters(new AddMatObjectParameters("name",
                "desc", new ArrayList<>(),
                Arrays.asList(1,2,3), MatType.AXIOM));
        runDispatcher(Map.of(
                ParameterMapKeys.NAME_KEY, "name",
                ParameterMapKeys.DESCRIPTION_KEY, "desc",
                ParameterMapKeys.DEPENDENCIES_KEY, new ArrayList<Integer>(),
                ParameterMapKeys.SOURCES_KEY, Arrays.asList(1,2,3),
                ParameterMapKeys.TYPE_KEY, MatType.AXIOM
        ));
    }

    @Test
    void test_InvalidAddMatObject(){
        expectExceptionInDispatcher(Map.of(
                ParameterMapKeys.NAME_KEY, "name"
        ));
    }
}
