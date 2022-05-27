package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;

import java.util.ArrayList;
import java.util.Map;

public class AddMathematicalObjectAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new AddMatObjectParameters(
                parser.parseString("name"),
                parser.parseString("desc"),
                new ArrayList<>(),
                parser.parseIntegerList("sources"),
                parser.parseMatType("type"))
        );
    }
}
