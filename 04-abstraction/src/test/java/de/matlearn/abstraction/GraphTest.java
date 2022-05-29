package de.matlearn.abstraction;

import de.matlearn.abstraction.graph.GenericVertex;
import de.matlearn.abstraction.graph.Graph;
import de.matlearn.abstraction.graph.UnknownVertexException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GraphTest {
    @Test
    void test_AddVertex() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(5);
        Assertions.assertTrue(builder.getGraph()
                .getVertices().containsAll(builder.getVertices()));
    }

    @Test
    void test_AddEdgeToExistingVertex() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(2);
        builder.addEdges(Map.of(0, 1));
        List<GenericVertex> vertices = builder.getVertices();
        Graph<GenericVertex> graph = builder.getGraph();
        assertCorrectEdges(graph.getForwardEdges(vertices.get(0)),
                Arrays.asList(vertices.get(1)));
        assertCorrectEdges(graph.getBackwardEdges(vertices.get(0)),
                new ArrayList<>());
        assertCorrectEdges(graph.getBackwardEdges(vertices.get(1)),
                Arrays.asList(vertices.get(0)));
        assertCorrectEdges(graph.getForwardEdges(vertices.get(1)),
                new ArrayList<>());
    }

    @Test
    void test_AddEdgeToNonexistingVertex() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(1);
        List<GenericVertex> vertices = builder.getVertices();
        Graph<GenericVertex> graph = builder.getGraph();
        Assertions.assertThrows(UnknownVertexException.class,
                () -> graph.addEdge(vertices.get(0), new GenericVertex()));
        assertCorrectEdges(graph.getForwardEdges(vertices.get(0)),
                new ArrayList<>());
        assertCorrectEdges(graph.getBackwardEdges(vertices.get(0)),
                new ArrayList<>());
    }

    @Test
    void test_RemoveEdge() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(2);
        builder.addEdges(Map.of(0, 1));
        List<GenericVertex> vertices = builder.getVertices();
        Graph<GenericVertex> graph = builder.getGraph();
        graph.removeEdge(vertices.get(0), vertices.get(1));
        assertNoEdges(graph, vertices.get(0));
        assertNoEdges(graph, vertices.get(1));
    }

    @Test
    void test_RemoveVertex() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(3);
        builder.addEdges(Map.of(
                0, 1,
                1, 2
        ));
        List<GenericVertex> vertices = builder.getVertices();
        Graph<GenericVertex> graph = builder.getGraph();
        graph.removeVertex(vertices.get(1));
        Assertions.assertEquals(2, graph.getVertices().size());
        Assertions.assertTrue(graph.getVertices().containsAll(
                Arrays.asList(vertices.get(0), vertices.get(2))
        ));
        assertNoEdges(graph, vertices.get(0));
        assertNoEdges(graph, vertices.get(2));
    }

    void assertCorrectEdges(List<GenericVertex> neighbors, List<GenericVertex> expectedNeighbors){
        Assertions.assertEquals(expectedNeighbors.size(), neighbors.size());
        Assertions.assertTrue(neighbors.containsAll(expectedNeighbors));
    }

    void assertNoEdges(Graph<GenericVertex> graph, GenericVertex vertex){
        Assertions.assertTrue(graph.getForwardEdges(vertex).isEmpty());
        Assertions.assertTrue(graph.getBackwardEdges(vertex).isEmpty());
    }
 }
