package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.ListLeavesUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.Map;

public class ListLeavesAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof ListLeavesUseCase)) return null;
        ListLeavesUseCase uc = (ListLeavesUseCase) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new SingleObjectParameters(parser.parseInteger("vertexId")));
    }
}
