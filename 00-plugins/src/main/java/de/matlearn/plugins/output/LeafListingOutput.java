package de.matlearn.plugins.output;

import de.matlearn.application.results.LeafListingResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class LeafListingOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof LeafListingResult){
            LeafListingResult result = (LeafListingResult) res;
            System.out.println("\nLeaves are:\n");
            PrintNamedVertices leaves = new PrintNamedVertices(result.getLeaves(), cliPrinter);
            leaves.printHeader();
            leaves.print();
            System.out.println("\n");
        }
    }
}
