package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddConnectionParameters;
import main.java.usecases.AddConnectionUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.Map;

public class AddConnectionAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof AddConnectionUseCase)) return null;
        AddConnectionUseCase uc = (AddConnectionUseCase) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new AddConnectionParameters(
                parser.parseInteger("fromVertex"),
                parser.parseInteger("toVertex"))
        );
    }
}
