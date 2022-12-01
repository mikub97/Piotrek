package com.company.graph;

import java.util.*;
import java.util.function.Consumer;

public class GraphUtils implements GraphUtilsI {
    @Override
    public <T> List<T> DFS(GraphI<T> graph, T t) {
        T active;
        Stack<T> stack = new Stack<>();
        List<T> visited = new ArrayList<>();
        stack.push(t);
        while (!stack.empty()){
            active = stack.pop();
            visited.add(active);
            for (T a : graph.getAdjacentNodesOf(active)) {
                if (!visited.contains(a)) stack.push(a);
            }
        }
        return visited;

    }

    @Override
    public <T> List<T> BFS(GraphI<T> graph, T t) {
        T active;
        Queue<T> queue = new LinkedList<>();
        List<T> visited = new ArrayList<>();
        queue.add(t);
        while (!queue.isEmpty()){
            active = queue.remove();
            visited.add(active);

            List<T> adjs = graph.getAdjacentNodesOf(active);
            Collections.reverse(adjs);
            for (T a : adjs) {
                if (!visited.contains(a)) queue.add(a);
            }

        }
        return visited;

    }

    @Override
    public <T> List<T> shortestPath(WeightedGraphI graph, T start, T end) {
        Map<T,Double> distances = new HashMap<>();
        Map<T,T> precedes = new HashMap<>();

//        graph.getNodes().forEach(new Consumer<T>() {
//            @Override
//            public void accept(T o) {
//                distances.put(o,Double.MAX_VALUE);
//                precedes.put(o,null);
//            }
//        });

        Comparator<T> comparator= new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (int) (distances.get(o1)-distances.get(o2));
            }
        };

        PriorityQueue<T> queue = new PriorityQueue(comparator);
        distances.replace(start,0.0);
        List<T> list = new ArrayList<>();
        list.add(queue.poll());
        list.add(queue.poll());
        return list;

    }


}
