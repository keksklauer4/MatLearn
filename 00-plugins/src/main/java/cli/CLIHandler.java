package main.java.cli;

import main.java.commands.GenericCommand;
import main.java.network.ProofNetworkRepository;

import java.util.Optional;

public class CLIHandler {
    private final ProofNetworkRepository networkRepository;
    private final InputParser inputParser;

    public CLIHandler(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
        this.inputParser = new InputParser();
    }

    public void run(){
        System.out.println("Welcome to Matlearn. Choose from one of the following commands:");
        commandLoop();
    }

    private void printCommands() {
        System.out.println("\n");
        int idx = 1;
        for (final GenericCommand command : CLICommands.getCommands()){
            System.out.println(idx++ + ") " + command.getName());
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
            System.out.print("Enter command: ");
            String line = inputParser.parseText();
            if (line.toLowerCase().equals("q")) return false;
            parsed = matchCommandInput(line);
            if (parsed == null){
                System.out.println("Invalid command.");
            }
        }
        CLICommandHandler handler = new CLICommandHandler(networkRepository, parsed);
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
