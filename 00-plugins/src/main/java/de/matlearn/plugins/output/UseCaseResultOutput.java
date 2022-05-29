package de.matlearn.plugins.output;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public interface UseCaseResultOutput {
    void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter);
}
