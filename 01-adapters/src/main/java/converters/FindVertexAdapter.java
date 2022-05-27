package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.FindVertexParameter;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.VertexFinder;

import java.util.Map;

public class FindVertexAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new FindVertexParameter(parser.parseString("search").strip()));
    }
}
