package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;

import java.util.ArrayList;
import java.util.Map;

public class AddMathematicalObjectAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof AddMathematicalObjectTask)) return null;
        AddMathematicalObjectTask uc = (AddMathematicalObjectTask) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new AddMatObjectParameters(
                parser.parseString("name"),
                parser.parseString("desc"),
                new ArrayList<>(),
                parser.parseIntegerList("sources"),
                parser.parseMatType("type"))
        );
    }
}
