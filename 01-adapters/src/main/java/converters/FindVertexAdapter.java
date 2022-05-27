package main.java.converters;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.FindVertexParameter;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.VertexFinder;

import java.util.Map;

public class FindVertexAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        if (!(useCase instanceof VertexFinder)) return null;
        VertexFinder uc = (VertexFinder) useCase;
        ParameterMapParser parser = new ParameterMapParser(parameterMap);
        return uc.execute(new FindVertexParameter(parser.parseString("search").strip()));
    }
}
