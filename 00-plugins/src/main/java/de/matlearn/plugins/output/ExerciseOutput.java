package de.matlearn.plugins.output;

import de.matlearn.application.results.RandomExerciseResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.plugins.cli.CLIPrinter;
import de.matlearn.plugins.cli.InputParser;

public class ExerciseOutput implements UseCaseResultOutput {
    @Override
    public void printUseCaseResult(UseCaseResult res, CLIPrinter cliPrinter) {
        if (res instanceof RandomExerciseResult) {
            NamedVertex chosenVertex = ((RandomExerciseResult) res).getVertex();
            cliPrinter.printLine("What is the definition of the "
                    + chosenVertex.getType().toString()
                    + " with name '" + chosenVertex.getName()
                    + "'?");
            cliPrinter.print("Description: ");
            InputParser parser = new InputParser();
            parser.parseText();
            cliPrinter.printLine("\nIs it the same as '" + chosenVertex.getDescription() + "' ?");
            parser.parseText();
        }
    }
}
