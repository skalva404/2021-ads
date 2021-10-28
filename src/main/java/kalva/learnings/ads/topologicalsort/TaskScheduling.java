package kalva.learnings.ads.topologicalsort;

import java.util.*;

/**
 * Problem Statement#
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
 * <p>
 * Example 1:
 * <p>
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * Output: true
 * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
 * to finish before '2' can be scheduled. One possible scheduling of tasks is: [0, 1, 2]
 * Example 2:
 * <p>
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
 * Output: false
 * Explanation: The tasks have a cyclic dependency, therefore they cannot be scheduled.
 * Example 3:
 * <p>
 * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
 * Output: true
 * Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]
 * Solution #
 * This problem is asking us to find out if it is possible to find a topological ordering of the given tasks. The tasks are equivalent to the vertices and the prerequisites are the edges.
 * <p>
 * We can use a similar algorithm as described in Topological Sort to find the topological ordering of the tasks. If the ordering does not include all the tasks, we will conclude that some tasks have cyclic dependencies.
 */
public class TaskScheduling {

    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0)
            return false;

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        // if sortedOrder doesn't contain all tasks, there is a cyclic dependency between tasks, therefore, we
        // will not be able to schedule all tasks
        return sortedOrder.size() == tasks;
    }

    public static void main(String[] args) {

        boolean result = isSchedulingPossible(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(3,
                new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(6, new int[][]{new int[]{2, 5}, new int[]{0, 5},
                new int[]{0, 4}, new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println("Tasks execution possible: " + result);
    }
}
