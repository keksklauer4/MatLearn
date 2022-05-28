package de.matlearn.plugins.cli;

public class CLIPrinterImpl implements CLIPrinter {
    @Override
    public void printLine(final String text){
        System.out.println(text);
    }

    @Override
    public void printLine(){
        System.out.println();
    }

    @Override
    public void print(final String text) {
        System.out.print(text);
    }

    @Override
    public void printLineSeparator() {
        printLine("--------------------");
    }
}
