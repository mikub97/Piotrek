package com.company.graph;

import com.company.graph.antColonyGraph.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GraphUtilsTest {
    private GraphI<Integer> simple_graph;
    private WeightedGraphI weightedGraph;

    private GraphUtils graphUtils;

    public GraphUtilsTest(){
        this.simple_graph = new MatrixGraph<>(false);
        simple_graph.addVertex(10);
        simple_graph.addEdge(10,73);
        simple_graph.addEdge(10,65);
        simple_graph.addEdge(10,51);
        simple_graph.addEdge(73,2);
        simple_graph.addEdge(73,3);
        simple_graph.addEdge(51,1001);
        simple_graph.addEdge(51,69);
        simple_graph.addEdge(3,1);
        simple_graph.addEdge(3,100);
        simple_graph.addEdge(1001,5);
        simple_graph.addEdge(1001,66);
        simple_graph.addEdge(1001,7);
        simple_graph.addEdge(5,53);
        simple_graph.addEdge(66,6);
        simple_graph.addEdge(7,8);
        simple_graph.addEdge(7,77);
        simple_graph.addEdge(6,-1);
        simple_graph.addEdge(6,54);

        this.weightedGraph = new MatrixWeightedGraph(false);
        weightedGraph.addVertex(10);
        weightedGraph.addEdge(10,73);
        weightedGraph.addEdge(10,65);
        weightedGraph.addEdge(10,51);
        weightedGraph.addEdge(73,2);
        weightedGraph.addEdge(73,3);
        weightedGraph.addEdge(51,1001);
        weightedGraph.addEdge(51,69);
        weightedGraph.addEdge(3,1);
        weightedGraph.addEdge(3,100);
        weightedGraph.addEdge(1001,5);
        weightedGraph.addEdge(1001,66);
        weightedGraph.addEdge(1001,7);
        weightedGraph.addEdge(5,53);
        weightedGraph.addEdge(66,6);
        weightedGraph.addEdge(7,8);
        weightedGraph.addEdge(7,77);
        weightedGraph.addEdge(6,-1);
        weightedGraph.addEdge(6,54);
        this.graphUtils= new GraphUtils();

    }

    @Test
    void graphutils(){
        System.out.println(graphUtils.BFS(simple_graph, 10));
    }

    @Test
    void dijstra(){
        List<Integer> integers = graphUtils.shortestPath(weightedGraph, 3, 5);
        System.out.println(integers);
    }
}
