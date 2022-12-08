package com.company.graph;

import java.lang.reflect.Executable;
import java.util.*;

interface WeightedGraphI< T extends Comparable<T>> extends GraphI<T>   {
    public List<Pair<T,Double>> getAdjacentNodesWithWeightsOf(T t);


    @Override
    default void addEdge(T source, T dest){};
    void addEdge(T source, T dest, double weight);
}
