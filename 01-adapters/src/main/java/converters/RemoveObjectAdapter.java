package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveObjectUseCase;

import java.util.Map;

public class RemoveObjectAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof RemoveObjectUseCase)) return null;
        RemoveObjectUseCase uc = (RemoveObjectUseCase) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new SingleObjectParameters(parser.parseInteger("vertexId")));
    }
}
