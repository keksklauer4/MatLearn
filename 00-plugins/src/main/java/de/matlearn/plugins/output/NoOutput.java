package de.matlearn.plugins.output;


import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.results.ValidCommandResult;

public class NoOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof ValidCommandResult){
            System.out.println("Successfully executed command.");
        }
    }
}
