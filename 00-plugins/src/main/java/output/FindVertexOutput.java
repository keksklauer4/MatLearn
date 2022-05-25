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
            PrintNamedVertices printer = new PrintNamedVertices(((FindVertexResult) res).getVerticesFound());
            printer.printHeader();
            printer.print();
            System.out.println("\n");
        }
    }
}
