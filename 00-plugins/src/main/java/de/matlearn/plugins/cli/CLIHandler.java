package de.matlearn.plugins.cli;

import de.matlearn.adapters.commands.GenericCommand;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.Optional;

public class CLIHandler {
    private final ProofNetworkRepository networkRepository;
    private final InputParser inputParser;
    private final CLIPrinter cliPrinter;

    public CLIHandler(ProofNetworkRepository networkRepository, CLIPrinter cliPrinter) {
        this.networkRepository = networkRepository;
        this.inputParser = new InputParser();
        this.cliPrinter = cliPrinter;
    }

    public void run(){
        cliPrinter.printLine("Welcome to Matlearn. Choose from one of the following commands:");
        commandLoop();
    }

    private void printCommands() {
        cliPrinter.printLine();
        int idx = 1;
        for (final GenericCommand command : CLICommands.getCommands()){
            cliPrinter.printLine(idx++ + ") " + command.getName());
        }
    }

    private void commandLoop(){
        boolean abort = false;
        while(!abort){
            printCommands();
            abort = !retrieveCommand();
        }
    }

    private boolean retrieveCommand() {
        GenericCommand parsed = null;
        while(parsed == null){
            cliPrinter.print("Enter command: ");
            String line = inputParser.parseText();
            if (line.toLowerCase().equals("q")) return false;
            parsed = matchCommandInput(line);
            if (parsed == null){
                cliPrinter.printLine("Invalid command.");
            }
        }
        CLICommandHandler handler = new CLICommandHandler(networkRepository, parsed, cliPrinter);
        handler.handle();
        return true;
    }

    private GenericCommand matchCommandInput(final String line){
        Optional<GenericCommand> cmd = CLICommands.getCommands().stream()
                .filter(command -> command.getName().equalsIgnoreCase(line))
                .findFirst();
        if (cmd.isPresent()) return cmd.get();
        try {
            int index = Integer.parseInt(line.strip()) - 1;
            if (index >= 0 && index < CLICommands.getCommands().size()) {
                return CLICommands.getCommands().get(index);
            }
        }
        catch(Exception ignored){}
        return null;
    }

}
