package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.ListNeighborsUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.Map;

public class ListNeighborsAdapter implements UseCaseParameterAdapter{
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new SingleObjectParameters(parser.parseInteger("vertexId")));
    }
}
