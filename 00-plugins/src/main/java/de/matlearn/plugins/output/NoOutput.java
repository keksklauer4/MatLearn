package de.matlearn.plugins.output;


import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.results.ValidCommandResult;
import de.matlearn.plugins.cli.CLIPrinter;

public class NoOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof ValidCommandResult){
            cliPrinter.printLine("Successfully executed command.");
        }
    }
}
