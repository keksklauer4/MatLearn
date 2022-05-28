package de.matlearn.plugins.output;

import de.matlearn.application.results.LeafListingResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class LeafListingOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof LeafListingResult){
            LeafListingResult result = (LeafListingResult) res;
            cliPrinter.printLine("\nLeaves are:");
            cliPrinter.printLineSeparator();
            PrintNamedVertices leaves = new PrintNamedVertices(result.getLeaves(), cliPrinter);
            leaves.printHeader();
            leaves.print();
            cliPrinter.printLine();
        }
    }
}
