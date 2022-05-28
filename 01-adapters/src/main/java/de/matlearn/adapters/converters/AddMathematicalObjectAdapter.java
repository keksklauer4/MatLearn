package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.AddMatObjectParameters;
import de.matlearn.application.usecases.MatLearnUseCase;

import java.util.ArrayList;

public class AddMathematicalObjectAdapter implements UseCaseParameterAdapter {
    @Override
    public UseCaseResult executeUseCase(MatLearnUseCase useCase, ParameterMapParser parser) {
        return useCase.execute(new AddMatObjectParameters(
                parser.parseString(ParameterMapKeys.NAME_KEY),
                parser.parseString(ParameterMapKeys.DESCRIPTION_KEY),
                parser.parseIntegerList(ParameterMapKeys.DEPENDENCIES_KEY),
                parser.parseIntegerList(ParameterMapKeys.SOURCES_KEY),
                parser.parseMatType(ParameterMapKeys.TYPE_KEY))
        );
    }
}
