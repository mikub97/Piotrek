package com.company.graph;

import java.util.*;

interface WeightedGraphI< T extends Comparable<T>> extends GraphI<T>   {
    public List<Pair<T,Double>> getAdjacentNodesWithWeightsOf(T t);
}
