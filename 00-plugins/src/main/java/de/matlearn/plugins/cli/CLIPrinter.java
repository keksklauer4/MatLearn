package de.matlearn.plugins.cli;

public interface CLIPrinter {
    void printLine(final String text);
    void printLine();
    void print(final String text);

    void printLineSeparator();
}
