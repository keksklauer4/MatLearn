package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveEdgesUseCase;

import java.util.Map;

public class RemoveEdgesAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof RemoveEdgesUseCase)) return null;
        RemoveEdgesUseCase uc = (RemoveEdgesUseCase) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new RemoveEdgesParameters(
                parser.parseIntegerList("vertexIdsFrom"),
                parser.parseIntegerList("vertexIdsTo"))
        );
    }
}
