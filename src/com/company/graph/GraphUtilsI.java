package com.company.graph;

import java.util.List;


public interface GraphUtilsI {

    public <T> List<T> DFS(GraphI<T> graph, T t);

    public <T> List<T> BFS(GraphI<T> graph, T t);

    public <T extends Comparable> List<Double> shortestPath(WeightedGraphI graph, T start, T  end);




}
