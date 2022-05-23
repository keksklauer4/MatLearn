package main.java.output;

import main.java.entities.NamedVertex;
import main.java.results.AddMatObjectResult;
import main.java.results.FindVertexResult;
import main.java.results.UseCaseResult;

public class FindVertexOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof FindVertexResult){
            FindVertexResult result = (FindVertexResult) res;
            System.out.println("Search: " + result.getSearchString());
            System.out.println("id \tname \tdescription");
            for (final NamedVertex vertex : result.getVerticesFound()){
                System.out.println(vertex.getId() + ") \t" + vertex.getName() + ": \t" + vertex.getDescription());
            }
        }
    }
}
