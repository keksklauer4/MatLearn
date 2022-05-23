package main.resources;

import main.java.output.AddMatObjectOutput;
import main.java.output.FindVertexOutput;
import main.java.output.UseCaseResultOutput;
import main.java.results.AddMatObjectResult;
import main.java.results.FindVertexResult;
import main.java.results.UseCaseResult;

import java.util.Map;

public class UseCaseResultDispatcher {
    private final UseCaseResult result;

    private static Map<Class<?>, UseCaseResultOutput> outputMap = Map.ofEntries(
            Map.entry(AddMatObjectResult.class, new AddMatObjectOutput()),
            Map.entry(FindVertexResult.class, new FindVertexOutput())
    );

    public UseCaseResultDispatcher(final UseCaseResult result) {
        this.result = result;
    }

    public void outputResult(){
        outputMap.get(result.getClass()).printUseCaseResult(result);
    }
}
