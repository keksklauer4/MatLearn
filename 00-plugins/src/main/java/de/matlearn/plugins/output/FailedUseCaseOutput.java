package de.matlearn.plugins.output;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class FailedUseCaseOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        System.out.println("Command execution failed.");
    }
}
