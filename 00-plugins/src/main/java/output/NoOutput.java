package main.java.output;


import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;

public class NoOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof ValidCommandResult){
            System.out.println("Successfully executed command.");
        }
    }
}
