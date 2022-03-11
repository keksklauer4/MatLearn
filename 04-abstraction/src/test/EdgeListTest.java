package test;

import main.graph.Edge;
import main.graph.EdgeList;
import main.graph.UnknownVertexException;
import main.graph.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.activation.UnknownObjectException;
import java.util.List;

public class EdgeListTest {
    private EdgeList edgeList;
    private Vertex vertexA;
    private Vertex vertexB;

    @BeforeEach
    void initialize(){
        edgeList = new EdgeList();
        vertexA = new Vertex(0);
        vertexB = new Vertex(1);
    }

    @Test
    void test_GetForwardAndBackwardEdges(){
        addVertices();
        addEdgeCheck();
    }

    @Test
    void test_AddEdgeThrowsException(){
        Assertions.assertThrows(UnknownVertexException.class, ()-> {
            edgeList.addEdge(vertexA, vertexB);
        });
    }

    @Test
    void test_GetEdgesVariationsThrowExceptions(){
        Assertions.assertThrows(UnknownVertexException.class, ()-> {
            edgeList.getForwardEdges(vertexA);
        });
        Assertions.assertThrows(UnknownVertexException.class, ()-> {
            edgeList.getBackwardEdges(vertexA);
        });
        Assertions.assertThrows(UnknownVertexException.class, ()-> {
            edgeList.getEdges(vertexA);
        });
    }

    @Test
    void test_AlreadyExistingEdge(){
        addVertices();
        edgeList.addEdge(vertexA, vertexB);
        addEdgeCheck();
    }


    private void addEdgeCheck(){
        edgeList.addEdge(vertexA, vertexB);
        assertNumberEdges(vertexA, 1, 0);
        assertNumberEdges(vertexB, 0, 1);
    }

    private void addVertices(){
        edgeList.addVertex(vertexA);
        edgeList.addVertex(vertexB);
    }

    private void assertNumberEdges(final Vertex vertex, int numberForwardEdges, int numberBackwardEdges){
        Assertions.assertEquals(numberForwardEdges, edgeList.getForwardEdges(vertex).size());
        Assertions.assertEquals(numberBackwardEdges, edgeList.getBackwardEdges(vertex).size());
    }
}
