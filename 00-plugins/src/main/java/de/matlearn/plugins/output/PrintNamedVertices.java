package de.matlearn.plugins.output;

import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.plugins.cli.CLIPrinter;

import java.util.List;

public class PrintNamedVertices {
    private final List<NamedVertex> vertexList;
    private final CLIPrinter cliPrinter;

    public PrintNamedVertices(List<NamedVertex> vertexList, CLIPrinter cliPrinter) {
        this.vertexList = vertexList;
        this.cliPrinter = cliPrinter;
    }

    public void printHeader(){
        cliPrinter.printLine("id \ttype \tname \tdescription");
    }

    public void print(){
        for (final NamedVertex vertex : vertexList){
            cliPrinter.printLine(vertex.getId() + ") \t"
                    + vertex.getType().toString()  + " \t"
                    + vertex.getName() + " \t"
                    + vertex.getDescription());
        }
    }

    public void printAll(){
        printHeader();
        print();
    }
}
