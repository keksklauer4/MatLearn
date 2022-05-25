package main.java.output;

import main.java.results.NeighborResult;
import main.java.results.UseCaseResult;

public class NeighborOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof NeighborResult){
            NeighborResult result = (NeighborResult) res;
            System.out.println("\n");
            PrintNamedVertices parentPrinter = new PrintNamedVertices(result.getParents());
            PrintNamedVertices descPrinter = new PrintNamedVertices(result.getDescendants());

            System.out.println("Direct parents are:");
            parentPrinter.printAll();
            System.out.println("\nDirect descendants:");
            descPrinter.printAll();
            System.out.println("\n");
        }
    }
}
