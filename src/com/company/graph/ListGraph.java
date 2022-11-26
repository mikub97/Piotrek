package com.company.graph;

import java.util.*;

public class ListGraph<T extends Comparable<T>> implements GraphI<T>{

    private Map<T, List<T>> adjacencyList;
    private boolean is_directed;


    public ListGraph(boolean is_directed){
        this.adjacencyList = new HashMap<>();
        this.is_directed = is_directed;
    }


    @Override
    public void addVertex(T t) {
        if(! adjacencyList.containsKey(t))   adjacencyList.put(t, new ArrayList<>());

    }

    @Override
    public void addEdge(T source, T dest) {
        if (!adjacencyList.containsKey(source)) addVertex(source);
        if (!adjacencyList.containsKey(dest)) addVertex(dest);
        if (this.is_directed)
            adjacencyList.get(source).add(dest);
        else {
            adjacencyList.get(source).add(dest);
            adjacencyList.get(dest).add(source);
        }
    }

    @Override
    public int getVertexCount() {
        return adjacencyList.size();
    }

    @Override
    public int getEdgeCount() {
        int c=0;
        for (List<T> adjs: adjacencyList.values()) {
            c += adjs.size();
        }
        return c;
    }

    @Override
    public boolean hasVertex(T t) {
        return adjacencyList.containsKey(t);
    }

    @Override
    public boolean hasEdge(T source, T dest) {
        return adjacencyList.get(source).contains(dest);
    }

    public List<T> getAdjacentNodesOf(T t){
        List<T> adjs = adjacencyList.get(t);
        adjs.sort((Comparator<? super T>) Comparator.naturalOrder().reversed());
        return adjs;
    }

}
