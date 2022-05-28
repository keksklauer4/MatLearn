package de.matlearn.plugins.output;

import de.matlearn.application.results.FindVertexResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class FindVertexOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof FindVertexResult){
            FindVertexResult result = (FindVertexResult) res;
            cliPrinter.printLine("Search: " + result.getSearchString());
            PrintNamedVertices printer = new PrintNamedVertices(((FindVertexResult) res).getVerticesFound(), cliPrinter);
            printer.printHeader();
            printer.print();
            cliPrinter.printLine("\n");
        }
    }
}
