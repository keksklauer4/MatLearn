package de.matlearn.plugins.output;

import de.matlearn.application.results.AddMatObjectResult;
import de.matlearn.application.results.UseCaseResult;

public class AddMatObjectOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res) {
        if (res instanceof AddMatObjectResult){
            System.out.println("Created object has id " + ((AddMatObjectResult) res).getId());
        }
    }
}
