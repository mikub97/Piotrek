package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph <T> implements GraphI<T>{

    private Map<T, List<T>> adjacencyList;

    public Graph(){
         this(true);
    }

    @Override
    public void addVertex(T t) {
        if(! adjacencyList.containsKey(t))   adjacencyList.put(t, new ArrayList<>());

    }

    @Override
    public void addEdge(T source, T dest) {
        if(!adjacencyList.containsKey(source)) addVertex(source);
        if(!adjacencyList.containsKey(dest)) addVertex(dest);
        if (!adjacencyList.get(source).contains(dest)) adjacencyList.get(source).add(dest);

    }

    @Override
    public int getVertexCount() {
        return adjacencyList.size();
    }

    @Override
    public int getEdgeCount() {
        int c=0;
        for (var adj: adjacencyList.values()) {
            c += adj.size();

        }
        return c;
//        return Math.toIntExact(adjacencyList.values().stream().collect(Collectors.counting()));
    }

    @Override
    public boolean hasVertex(T t) {
        return adjacencyList.containsKey(t);
    }

    @Override
    public boolean hasEdge(T source, T dest) {
        return adjacencyList.get(source).contains(dest);
    }
}
