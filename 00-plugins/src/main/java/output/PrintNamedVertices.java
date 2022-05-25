package main.java.output;

import main.java.entities.NamedVertex;

import java.util.Collections;
import java.util.List;

public class PrintNamedVertices {
    private final List<NamedVertex> vertexList;

    public PrintNamedVertices(NamedVertex vertex){
        this.vertexList = Collections.singletonList(vertex);
    }

    public PrintNamedVertices(List<NamedVertex> vertexList) {
        this.vertexList = vertexList;
    }

    public void printHeader(){
        System.out.println("id \tname \tdescription");
    }

    public void print(){
        for (final NamedVertex vertex : vertexList){
            System.out.println(vertex.getId() + ") \t"
                    + vertex.getName() + ": \t"
                    + vertex.getDescription());
        }
    }

    public void printAll(){
        printHeader();
        print();
    }
}
