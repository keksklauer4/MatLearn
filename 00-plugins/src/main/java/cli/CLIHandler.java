package main.java.cli;

import main.java.commands.GenericCommand;

import java.util.Scanner;

public class CLIHandler {
    public void run(){
        System.out.println("Welcome to Matlearn. Choose from one of the following commands:");
        int idx = 1;
        for (final GenericCommand command : CLICommands.commands){
            System.out.println(idx++ + ") " + command.getName());
        }
        commandLoop();
    }

    private void commandLoop(){
        boolean abort = false;
        while(!abort){
            abort = !retrieveCommand();
        }
    }

    private boolean retrieveCommand() {
        Scanner scanner = new Scanner(System.in);
        GenericCommand parsed = null;
        while(parsed == null){
            System.out.print("Enter command: ");
            String line = scanner.nextLine().strip();
            if (line.toLowerCase().equals("q")) return false;
            parsed = matchCommandInput(line);
            if (parsed == null){
                System.out.println("Invalid command.");
            }
        }
        CLICommandHandler handler = new CLICommandHandler(parsed);
        handler.handle();
        return true;
    }

    private GenericCommand matchCommandInput(final String line){
        System.out.println("Line: \"" + line + "\"");
        for(final GenericCommand command : CLICommands.commands){
            if (command.getName().toLowerCase().equals(line)){
                return command;
            }
        }
        try {
            int index = Integer.parseInt(line.strip()) - 1;
            if (index >= 0 && index < CLICommands.commands.size()) {
                return CLICommands.commands.get(index);
            }
        }
        catch(Exception ignored){}
        return null;
    }

}
