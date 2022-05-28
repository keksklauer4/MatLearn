package de.matlearn.plugins.cli;

import de.matlearn.adapters.commands.GenericCommand;
import de.matlearn.adapters.converters.UseCaseParameterDispatcher;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.Parameter;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.adapters.validators.InvalidInputException;
import de.matlearn.plugins.output.UseCaseResultDispatcher;

import java.util.Optional;

public class CLICommandHandler {
    private final ProofNetworkRepository networkRepository;
    private final InputParser inputParser;
    private final GenericCommand command;
    private final CLIPrinter cliPrinter;

    public CLICommandHandler(ProofNetworkRepository networkRepository, GenericCommand command, CLIPrinter cliPrinter) {
        this.networkRepository = networkRepository;
        this.inputParser = new InputParser();
        this.command = command;
        this.cliPrinter = cliPrinter;
    }

    public void handle(){
        cliPrinter.printLineSeparator();
        cliPrinter.printLine(command.getName() + ": " + command.getHelpText());
        int nbRemaining = command.getParameters().size();
        while(nbRemaining > 0) {
            printRemainingParameters();
            if(parseParameter()) nbRemaining--;
        }
        MatLearnUseCase useCase = command.getParametrizedUseCase(networkRepository);
        UseCaseParameterDispatcher parameterDispatcher = new UseCaseParameterDispatcher(
                useCase, command.getParameterMap());
        UseCaseResult res = parameterDispatcher.dispatch();
        UseCaseResultDispatcher dispatcher = new UseCaseResultDispatcher(res, cliPrinter);
        dispatcher.outputResult();
    }


    private void printRemainingParameters(){
        cliPrinter.printLine("Parameters:");
        for (final Parameter parameter : command.getParameters()){
            if (parameter.getInput() == null) {
                cliPrinter.printLine(parameter.getId() + ") " + parameter.getParameterName());
            }
        }
    }

    private boolean parseParameter(){
        Parameter parameter = null;
        while(parameter == null) {
            cliPrinter.print("Enter parameter index: ");
            parameter = selectParameter();
            if (parameter == null || parameter.getInput() != null) {
                cliPrinter.printLine("\nInvalid index.");
            }
        }
        cliPrinter.printLineSeparator();
        parseParameterInput(parameter);
        return true;
    }

    private Parameter selectParameter(){
        Optional<Integer> requestedId = inputParser.parseInt();
        if (requestedId.isEmpty()) return null;

        Optional<Parameter> parameter = command.getParameters()
                .stream()
                .filter(para -> para != null && para.getId() == requestedId.get() && para.getInput() == null)
                .findFirst();
        return parameter.orElse(null);
    }

    private void parseParameterInput(final Parameter parameter){
        do {
            cliPrinter.print("Enter input: ");
        } while (!readParameter(parameter));
    }

    private boolean readParameter(final Parameter parameter){
        try {
            command.setInput(parameter, inputParser.parseText());
            return true;
        } catch (InvalidInputException e){
            cliPrinter.printLine("Invalid input: " + e.getMessage());
            return false;
        }
    }
}
