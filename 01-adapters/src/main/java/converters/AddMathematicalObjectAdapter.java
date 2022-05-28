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
                parser.parseString(ParameterMapKeys.NAME_KEY),
                parser.parseString(ParameterMapKeys.DESCRIPTION_KEY),
                new ArrayList<>(),
                parser.parseIntegerList(ParameterMapKeys.SOURCES_KEY),
                parser.parseMatType(ParameterMapKeys.TYPE_KEY))
        );
    }
}
