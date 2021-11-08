package kalva.learnings.ads.backtracking;

public class HamiltonianCycle {

    static void printSolution(int path[]) {
        System.out.print("Following is one Hamiltonian Cycle ::");
        for (int j : path) System.out.print(" " + j + " ");
        System.out.println(" " + path[0] + " ");
    }

    static boolean isSafe(int v, int graph[][], int path[], int pos) {

        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static void solve(int[][] graph, int[] path, int position) {

        int totalVertexes = graph[0].length;
        //This condition is to check whether the loop exists
        if (position == totalVertexes && graph[path[position - 1]][path[0]] == 1) {
            printSolution(path);
        }

        for (int vertex = 1; vertex < totalVertexes; vertex++) {
            if (!isSafe(vertex, graph, path, position)) {
                continue;
            }
            path[position] = vertex;
            solve(graph, path, position + 1);
            path[position] = -1;
        }
    }

    public static void main(String[] args) {

        final int V = 5;

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int[][] graph1 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        int[] path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;
        path[0] = 0;
        // Print the solution
        solve(graph1, path, 1);
        System.out.println("\n");

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int[][] graph2 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;
        path[0] = 0;
        // Print the solution
        solve(graph2, path, 1);
    }
}
