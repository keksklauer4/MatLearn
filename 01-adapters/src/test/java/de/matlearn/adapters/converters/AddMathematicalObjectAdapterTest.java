package de.matlearn.adapters.converters;

import de.matlearn.application.usecaseparameters.AddMatObjectParameters;
import de.matlearn.application.usecases.AddMathematicalObjectTask;
import de.matlearn.domain.entities.MatType;
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
