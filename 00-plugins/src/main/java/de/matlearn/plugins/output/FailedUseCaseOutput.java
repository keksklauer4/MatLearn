package de.matlearn.plugins.output;

import de.matlearn.application.results.UseCaseResult;

public class FailedUseCaseOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        System.out.println("Command execution failed.");
    }
}
