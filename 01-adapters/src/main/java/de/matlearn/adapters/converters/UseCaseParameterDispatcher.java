package de.matlearn.adapters.converters;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecases.*;

import java.util.Map;

public class UseCaseParameterDispatcher {
    private final MatLearnUseCase useCase;
    private final Map<String, Object> parameterMap;

    private static final Map<Class<?  extends MatLearnUseCase>, UseCaseParameterAdapter> outputMap = Map.ofEntries(
            Map.entry(AddConnectionUseCase.class, new AddConnectionAdapter()),
            Map.entry(AddMathematicalObjectTask.class, new AddMathematicalObjectAdapter()),
            Map.entry(ListLeavesUseCase.class, new ListLeavesAdapter()),
            Map.entry(ListNeighborsUseCase.class, new ListNeighborsAdapter()),
            Map.entry(RemoveEdgesUseCase.class, new RemoveEdgesAdapter()),
            Map.entry(RemoveObjectUseCase.class, new RemoveObjectAdapter()),
            Map.entry(FindVerticesUseCase.class, new FindVertexAdapter()),
            Map.entry(FullValidationUseCase.class, new EmptyAdapter()),
            Map.entry(ExerciseUseCase.class, new EmptyAdapter()),
            Map.entry(ShowAllObjectsUseCase.class, new EmptyAdapter())
    );

    public UseCaseParameterDispatcher(MatLearnUseCase useCase, Map<String, Object> parameterMap) {
        this.useCase = useCase;
        this.parameterMap = parameterMap;
    }

    public UseCaseResult dispatch(){
        return outputMap
                .get(useCase.getClass())
                .executeUseCase(useCase, new ParameterMapParser(parameterMap));
    }
}
