package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.MatLearnUseCase;

public class ListNeighborsAdapter implements UseCaseParameterAdapter{
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new SingleObjectParameters(parser.parseInteger(ParameterMapKeys.VERTEX_ID_KEY)));
    }
}
