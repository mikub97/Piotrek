package com.company.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest<T> {
    private GraphI<Integer> matrixGraph;
    private WeightedGraphI<Integer> weightedGraph;

    private GraphI<Integer> integerListGraph;
    private List<GraphI> graphs;


    public GraphTest(){
        this.matrixGraph = new MatrixGraph<>(true );
        matrixGraph.addEdge(1,2);
        matrixGraph.addEdge(2,3);
        matrixGraph.addEdge(3,4);
        matrixGraph.addEdge(1,4);
        matrixGraph.addEdge(1,3);


        this.integerListGraph = new ListGraph<>(false);
        integerListGraph.addEdge(1,2);
        integerListGraph.addEdge(2,3);
        integerListGraph.addEdge(3,4);
        integerListGraph.addEdge(1,4);
        integerListGraph.addEdge(1,3);


        graphs = new ArrayList<>();
        graphs.addAll(List.of(new GraphI[]{integerListGraph, matrixGraph}));
    }
    @Test
    void addVertexTest(){

        for (int i = 0; i < graphs.size(); i++) {
            graphs.get(i).addVertex(10);
            assert graphs.get(i).hasVertex(10);

        }


    }
    @Test
    public void addEdge(){

        for (int i = 0; i < graphs.size(); i++) {
            assert  !graphs.get(i).hasEdge(10,1);
            assert  graphs.get(i).hasEdge(1,3);

            graphs.get(i).addEdge(10,1);

            assert  graphs.get(i).hasEdge(10,1);
            graphs.get(i).addEdge(106,108);
        }

    }
    @Test
    public void getVertexCount() {
        for (int i = 0; i < graphs.size(); i++) {
            assert  graphs.get(i).getVertexCount()==4;

        }
    }
    @Test
    public void getEdgeCount(){
        for (int i = 0; i < graphs.size(); i++) {
            assert graphs.get(i).getEdgeCount() == 5;
            graphs.get(i).addEdge(1,10);
            assert graphs.get(i).getEdgeCount() == 6;


        }
    }

    @Test
    public void hasEdge(){
        assert matrixGraph.hasEdge(1,3);
        assert ! matrixGraph.hasEdge(2,4);
        assert !matrixGraph.hasEdge(2,10);
    }
    @Test
    public void getAdjacents(){

        for (int i = 0; i < graphs.size(); i++) {
            if (!graphs.get(i).isDirected()) {
                assert graphs.get(i).getAdjacentNodesOf(3).contains(2);
                assert graphs.get(i).getAdjacentNodesOf(3).contains(1);
                assert graphs.get(i).getAdjacentNodesOf(3).contains(4);
                assert !graphs.get(i).getAdjacentNodesOf(3).contains(10);
                assert !graphs.get(i).getAdjacentNodesOf(3).contains(3);
                assert graphs.get(i).getAdjacentNodesOf(3).size() == 3;
                assert graphs.get(i).getAdjacentNodesOf(4).size() == 2;
            }else{
                assert graphs.get(i).getAdjacentNodesOf(1).contains(2);
                assert graphs.get(i).getAdjacentNodesOf(1).contains(3);
                assert graphs.get(i).getAdjacentNodesOf(1).contains(4);
                assert graphs.get(i).getAdjacentNodesOf(2).contains(3);
                assert graphs.get(i).getAdjacentNodesOf(3).contains(4);
                assert !graphs.get(i).getAdjacentNodesOf(3).contains(10);
                assert !graphs.get(i).getAdjacentNodesOf(3).contains(3);
                assert graphs.get(i).getAdjacentNodesOf(3).size() == 1;
                assert graphs.get(i).getAdjacentNodesOf(4).size() == 0;
            }
        }
    }

    
    
}
