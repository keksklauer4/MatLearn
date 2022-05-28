package de.matlearn.plugins.output;

import de.matlearn.application.results.FindVertexResult;
import de.matlearn.application.results.UseCaseResult;

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
