package main.java.cli;

import main.java.commands.GenericCommand;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.Parameter;
import main.java.results.UseCaseResult;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

import java.util.Optional;
import java.util.Scanner;

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
        UseCaseResult res = useCase.execute();
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
        Integer requestedId = inputParser.parseInt();
        if (requestedId == null) return null;

        Optional<Parameter> parameter = command.getParameters()
                .stream()
                .filter(para -> para != null && para.getId() == requestedId)
                .findFirst();
        return parameter.orElse(null);
    }

    private void parseParameterInput(final Parameter parameter){
        do {
            System.out.println("Enter input:");
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
