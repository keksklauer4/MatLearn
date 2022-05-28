package de.matlearn.plugins.cli;

import de.matlearn.adapters.commands.GenericCommand;
import de.matlearn.adapters.converters.UseCaseParameterDispatcher;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.Parameter;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.adapters.validators.InvalidInputException;

import java.util.Optional;

public class CLICommandHandler {
    private final ProofNetworkRepository networkRepository;
    private final InputParser inputParser;
    private final GenericCommand command;

    public CLICommandHandler(ProofNetworkRepository networkRepository, GenericCommand command) {
        this.networkRepository = networkRepository;
        this.inputParser = new InputParser();
        this.command = command;
    }

    public void handle(){
        System.out.println(command.getName() + ": " + command.getHelpText());
        int nbRemaining = command.getParameters().size();
        while(nbRemaining > 0) {
            printRemainingParameters();
            if(parseParameter()) nbRemaining--;
        }
        MatLearnUseCase useCase = command.getParametrizedUseCase(networkRepository);
        UseCaseParameterDispatcher parameterDispatcher = new UseCaseParameterDispatcher(
                useCase, command.getParameterMap());
        UseCaseResult res = parameterDispatcher.dispatch();
        UseCaseResultDispatcher dispatcher = new UseCaseResultDispatcher(res);
        dispatcher.outputResult();
    }


    private void printRemainingParameters(){
        System.out.println("Parameters:");
        for (final Parameter parameter : command.getParameters()){
            if (parameter.getInput() == null) {
                System.out.println(parameter.getId() + ") " + parameter.getParameterName());
            }
        }
    }

    private boolean parseParameter(){
        Parameter parameter = null;
        while(parameter == null) {
            System.out.println("Enter parameter index: ");
            parameter = selectParameter();
            if (parameter == null || parameter.getInput() != null) {
                System.out.println("Invalid index.");
            }
        }
        parseParameterInput(parameter);
        return true;
    }

    private Parameter selectParameter(){
        Optional<Integer> requestedId = inputParser.parseInt();
        if (requestedId.isEmpty()) return null;

        Optional<Parameter> parameter = command.getParameters()
                .stream()
                .filter(para -> para != null && para.getId() == requestedId.get())
                .findFirst();
        return parameter.orElse(null);
    }

    private void parseParameterInput(final Parameter parameter){
        do {
            System.out.print("Enter input: ");
        } while (!readParameter(parameter));
    }

    private boolean readParameter(final Parameter parameter){
        try {
            command.setInput(parameter, inputParser.parseText());
            return true;
        } catch (InvalidInputException e){
            System.out.println("Invalid input: " + e.getMessage());
            return false;
        }
    }
}
