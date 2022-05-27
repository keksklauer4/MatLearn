package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.AddConnectionParameters;
import main.java.usecases.MatLearnUseCase;

import java.util.Map;

public class AddConnectionAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new AddConnectionParameters(
                parser.parseInteger("fromVertex"),
                parser.parseInteger("toVertex"))
        );
    }
}
