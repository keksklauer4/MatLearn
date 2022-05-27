package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.ListNeighborsUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.Map;

public class ListNeighborsAdapter implements UseCaseParameterAdapter{
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof ListNeighborsUseCase)) return null;
        ListNeighborsUseCase uc = (ListNeighborsUseCase) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new SingleObjectParameters(parser.parseInteger("vertexId")));
    }
}
