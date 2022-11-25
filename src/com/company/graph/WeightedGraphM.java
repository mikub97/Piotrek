package com.company.graph;

import java.net.ProxySelector;
import java.util.*;
import java.util.Map.Entry;

public class WeightedGraphM< T extends Comparable<T>> extends GraphM<T>   {

    public WeightedGraphM(int size, boolean is_directed){
        super(size,is_directed,true);

    }

    public List<Pair<T,Double>> getAdjecentsWithWeights(T t) {
        List<Pair<T,Double>> adjacents = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (this.adjMatrix[getIndex(t)][i] != -1) {
                adjacents.add(new Pair(data.get(i),this.adjMatrix[getIndex(t)][i] ));

            }
        }
        return adjacents;
    }
}
