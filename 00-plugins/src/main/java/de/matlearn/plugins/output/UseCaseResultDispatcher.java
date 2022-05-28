package de.matlearn.plugins.output;

import de.matlearn.application.results.*;
import de.matlearn.plugins.cli.CLIPrinter;

import java.util.Map;

public class UseCaseResultDispatcher {
    private final UseCaseResult result;
    private final CLIPrinter cliPrinter;

    private static Map<Class<?>, UseCaseResultOutput> outputMap = Map.ofEntries(
            Map.entry(AddMatObjectResult.class, new AddMatObjectOutput()),
            Map.entry(FindVertexResult.class, new FindVertexOutput()),
            Map.entry(ValidCommandResult.class, new NoOutput()),
            Map.entry(NeighborResult.class, new NeighborOutput()),
            Map.entry(LeafListingResult.class, new LeafListingOutput()),
            Map.entry(FailedUseCaseResult.class, new FailedUseCaseOutput()),
            Map.entry(RandomExerciseResult.class, new ExerciseOutput()),
            Map.entry(ShowAllObjectsResult.class, new ShowAllObjectsOutput())
    );

    public UseCaseResultDispatcher(UseCaseResult result, CLIPrinter cliPrinter) {
        this.result = result;
        this.cliPrinter = cliPrinter;
    }

    public void outputResult(){
        if (result == null) return;
        outputMap.get(result.getClass()).printUseCaseResult(result, cliPrinter);
    }
}
