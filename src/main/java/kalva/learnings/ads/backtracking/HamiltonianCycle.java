package kalva.learnings.ads.backtracking;

public class HamiltonianCycle {

    static void printSolution(int[] path) {
        System.out.print("Following is one Hamiltonian Cycle ::");
        for (int j : path) System.out.print(" " + j + " ");
        System.out.println(" " + path[0] + " ");
    }

    static boolean isSafe(int v, int[][] graph, int[] path, int pos) {

        /* Check if this vertex is an adjacent vertex of
           the previously added vertex. */
        if (graph[path[pos - 1]][v] == 0)
            return false;

        /* Check if the vertex has already been included.
           This step can be optimized by creating an array
           of size V */
        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static void solve(int[][] graph, int[] path, int position) {

        int totalNodes = graph[0].length;
        //This condition is to check whether the loop exists
        if (position == totalNodes && graph[path[position - 1]][path[0]] == 1) {
            printSolution(path);
        }

        for (int node = 1; node < totalNodes; node++) {
            if (!isSafe(node, graph, path, position)) {
                continue;
            }
            path[position] = node;
            solve(graph, path, position + 1);
            path[position] = -1;
        }
    }

    public static void main(String[] args) {

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        int[] path = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            path[i] = -1;
        path[0] = 0;
        // Print the solution
        solve(graph, path, 1);
        System.out.println("\n");

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        graph = new int[][]{
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        path = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            path[i] = -1;
        path[0] = 0;
        // Print the solution
        solve(graph, path, 1);
    }
}
