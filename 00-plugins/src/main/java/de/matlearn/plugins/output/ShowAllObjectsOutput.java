package de.matlearn.plugins.output;

import de.matlearn.application.results.LeafListingResult;
import de.matlearn.application.results.ShowAllObjectsResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class ShowAllObjectsOutput implements UseCaseResultOutput{
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof ShowAllObjectsResult){
            ShowAllObjectsResult result = (ShowAllObjectsResult) res;
            cliPrinter.printLineSeparator();
            PrintNamedVertices vertices = new PrintNamedVertices(result.getVertices(), cliPrinter);
            vertices.printHeader();
            vertices.print();
            cliPrinter.printLine();
        }
    }
}
