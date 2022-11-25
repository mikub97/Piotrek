package com.company.graph;

import java.util.*;

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
            for (T a : graph.getAdjacents(active)) {
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

            List<T> adjs = graph.getAdjacents(active);
            Collections.reverse(adjs);
            for (T a : adjs) {
                if (!visited.contains(a)) queue.add(a);
            }

        }
        return visited;

    }


}
