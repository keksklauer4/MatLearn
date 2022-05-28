package main.java.output;

import main.java.results.UseCaseResult;

public class FailedUseCaseOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        System.out.println("Command execution failed.");
    }
}
