package com.company.graph;

import java.util.List;

public interface GraphI <T>{

    void addVertex(T t);
    void addEdge(T source, T dest);
    int getVertexCount();
    int getEdgeCount();
    boolean hasVertex(T t);
    boolean hasEdge(T source, T destination);
    List<T> getAdjacents(T t);
    void DFS(T t);
    String toString();

    void DFS_recursive(T t);
}
