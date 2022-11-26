package com.company.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest<T> {
    private GraphI<Integer> integerMatrixGraph;
    private GraphI<Integer> integerListGraph;
    private List<GraphI> graphs;


    public GraphTest(){
        this.integerMatrixGraph = new MatrixGraph<>(false);
        integerMatrixGraph.addEdge(1,2);
        integerMatrixGraph.addEdge(2,3);
        integerMatrixGraph.addEdge(3,4);
        integerMatrixGraph.addEdge(1,4);
        integerMatrixGraph.addEdge(1,3);

        this.integerListGraph = new MatrixGraph<>(false);
        integerListGraph.addEdge(1,2);
        integerListGraph.addEdge(2,3);
        integerListGraph.addEdge(3,4);
        integerListGraph.addEdge(1,4);
        integerListGraph.addEdge(1,3);

        graphs = new ArrayList<>();
        graphs.addAll(List.of(new GraphI[]{integerListGraph, integerMatrixGraph}));
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
        System.out.println(integerMatrixGraph.getEdgeCount());
        assert integerMatrixGraph.getEdgeCount() ==5;

    }

    @Test
    public void hasEdge(){
        assert integerMatrixGraph.hasEdge(1,3);
        assert ! integerMatrixGraph.hasEdge(2,4);
        assert !integerMatrixGraph.hasEdge(2,10);
    }
    @Test
    public void getAdjacents(){
        for (int i = 0; i < graphs.size(); i++) {
            assert graphs.get(i).getAdjacentNodesOf(3).contains(2);
            assert graphs.get(i).getAdjacentNodesOf(3).contains(1);
            assert graphs.get(i).getAdjacentNodesOf(3).contains(4);
            assert !graphs.get(i).getAdjacentNodesOf(3).contains(10);
            assert !graphs.get(i).getAdjacentNodesOf(3).contains(3);
            assert graphs.get(i).getAdjacentNodesOf(3).size()==3;
            assert graphs.get(i).getAdjacentNodesOf(4).size()==2;
        }
    }

    
    
}
