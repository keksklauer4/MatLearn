package main.java.cli;

import main.java.commands.*;

import java.util.Arrays;
import java.util.List;

public class CLICommands {
    public static List<GenericCommand> getCommands() {
        return Arrays.asList(
                new AddDefinedObjectCommand(),
                new AddTheoremCommand(),
                new FindObjectCommand(),
                new AddConnectionCommand(),
                new LeavesCommand(),
                new ObjectNeighborhoodCommand(),
                new RemoveEdgeCommand(),
                new RemoveObjectCommand()
        );
    }
}
