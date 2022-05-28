package de.matlearn.plugins.cli;


import de.matlearn.adapters.commands.*;

import java.util.Arrays;
import java.util.List;

public class CLICommands {
    public static List<GenericCommand> getCommands() {
        return Arrays.asList(
                new AddDefinedObjectCommand(),
                new AddProvenResultCommand(),
                new AddGeneralObjectCommand(),
                new FindObjectCommand(),
                new FullValidationCommand(),
                new AddConnectionCommand(),
                new LeavesCommand(),
                new ObjectNeighborhoodCommand(),
                new RemoveEdgeCommand(),
                new RemoveObjectCommand(),
                new ExerciseCommand()
        );
    }
}
