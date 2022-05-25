package main.java.cli;

import main.java.output.*;
import main.java.results.*;

import java.util.Map;

public class UseCaseResultDispatcher {
    private final UseCaseResult result;

    private static Map<Class<?>, UseCaseResultOutput> outputMap = Map.ofEntries(
            Map.entry(AddMatObjectResult.class, new AddMatObjectOutput()),
            Map.entry(FindVertexResult.class, new FindVertexOutput()),
            Map.entry(ValidCommandResult.class, new NoOutput()),
            Map.entry(NeighborResult.class, new NeighborOutput()),
            Map.entry(LeafListingResult.class, new LeafListingOutput())
    );

    public UseCaseResultDispatcher(final UseCaseResult result) {
        this.result = result;
    }

    public void outputResult(){
        outputMap.get(result.getClass()).printUseCaseResult(result);
    }
}
