package kalva.learnings.ads.backtracking;

//https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
public class MColoring {

    static void printSolution(int[] color) {
        System.out.print("Solution Exists:");
        for (int j : color) System.out.print("  " + j);
        System.out.println();
    }

    static boolean isSafe(int vertex, int color, boolean graph[][], int colors[]) {
        for (int i = 0; i < graph[0].length; i++) {
            if (graph[vertex][i] && color == colors[i]) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int vertex, int totalColors, int[] assignedColors, boolean[][] graph) {

        if (vertex == assignedColors.length) {
            printSolution(assignedColors);
            return;
        }

        for (int color = 1; color <= totalColors; color++) {
            if (!isSafe(vertex, color, graph, assignedColors)) {
                continue;
            }
            assignedColors[vertex] = color;
            dfs(vertex + 1, totalColors, assignedColors, graph);
            assignedColors[vertex] = 0;
        }
    }

    public static void main(String[] args) {

        /* Create following graph and
        test whether it is 3 colorable
        (3)---(2)
        | / |
        | / |
        | / |
        (0)---(1)
        */
        boolean[][] graph = {
                {false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false},
        };

        int m = 3;
        int[] color = new int[graph[0].length];
        for (int i = 0; i < graph[0].length; i++) {
            color[i] = 0;
        }
        dfs(0, m, color, graph);
    }
}
