package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.FindVertexParameter;
import de.matlearn.application.usecases.MatLearnUseCase;

public class FindVertexAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new FindVertexParameter(parser.parseString(ParameterMapKeys.SEARCH_KEY).strip()));
    }
}
