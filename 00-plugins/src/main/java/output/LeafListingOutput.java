package main.java.output;

import main.java.results.LeafListingResult;
import main.java.results.UseCaseResult;

public class LeafListingOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof LeafListingResult){
            LeafListingResult result = (LeafListingResult) res;
            System.out.println("\nLeaves are:\n");
            PrintNamedVertices leaves = new PrintNamedVertices(result.getLeaves());
            leaves.printHeader();
            leaves.print();
            System.out.println("\n");
        }
    }
}