package main.java.output;

import main.java.results.AddMatObjectResult;
import main.java.results.UseCaseResult;

public class AddMatObjectOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof AddMatObjectResult){
            System.out.println("Created object has id " + ((AddMatObjectResult) res).getId());
        }
    }
}
