package de.matlearn.plugins.output;

import de.matlearn.application.results.NeighborResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class NeighborOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof NeighborResult){
            NeighborResult result = (NeighborResult) res;
            cliPrinter.printLine();
            PrintNamedVertices parentPrinter = new PrintNamedVertices(result.getParents(), cliPrinter);
            PrintNamedVertices descPrinter = new PrintNamedVertices(result.getDescendants(), cliPrinter);

            cliPrinter.printLine("Direct parents are:");
            parentPrinter.printAll();
            cliPrinter.printLine("\nDirect descendants:");
            descPrinter.printAll();
            cliPrinter.printLine();
        }
    }
}
