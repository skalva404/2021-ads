package kalva.learnings.ads.topologicalsort;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {

        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        //Build the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int[] edge : edges) {
            int parent = edge[0], child = edge[1];
            inDegree.compute(child, (k, v) -> (null == v) ? 1 : v + 1);
            graph.compute(parent, (k, v) -> {
                if (null == v) {
                    v = new ArrayList<>();
                }
                v.add(child);
                return v;
            });
        }

        //Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (null == inDegree.get(i)) {
                sources.add(i);
            }
        }

        while (!sources.isEmpty()) {
            Integer vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> edgesToRemove = graph.get(vertex);
            if (null == edgesToRemove) {
                continue;
            }
            for (Integer ver : edgesToRemove) {
                inDegree.put(ver, inDegree.get(ver) - 1);
                if (0 == inDegree.get(ver)) {
                    sources.add(ver);
                }
            }
        }
        if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {

        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{
                        {3, 2},
                        {3, 0},
                        {2, 0},
                        {2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][]
                {
                        new int[]{4, 2},
                        new int[]{4, 3}, new int[]{2, 0},
                        new int[]{2, 1}, new int[]{3, 1}
                });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][]

                {
                        new int[]{6, 4}, new int[]{3, 1},
                        new int[]{6, 2}, new int[]{5, 3},
                        new int[]{5, 4}, new int[]{3, 0},
                        new int[]{3, 2}, new int[]{4, 1}
                });
        System.out.println(result);
    }
}
