package com.company.graph;

public class Pair <T,Double> {
    private final Double weight;
    private final T t;

    public Pair(T t, Double w){
        this.t = t;
        this.weight = w;
    }

    public Double getWeight() {
        return weight;
    }

    public T getT() {
        return t;
    }
}
