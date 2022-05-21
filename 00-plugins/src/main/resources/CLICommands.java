package main.resources;

import main.java.commands.AddDefinedObjectCommand;
import main.java.commands.AddTheoremCommand;
import main.java.commands.GenericCommand;

import java.util.Arrays;
import java.util.List;

public class CLICommands {
    public static List<GenericCommand> commands = Arrays.asList(
            new AddDefinedObjectCommand(),
            new AddTheoremCommand()
    );
}
