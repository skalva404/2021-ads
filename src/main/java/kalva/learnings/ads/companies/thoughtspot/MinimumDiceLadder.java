package kalva.learnings.ads.companies.thoughtspot;

import kalva.learnings.ads.SaLCell;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/snake-ladder-problem-2/
public class MinimumDiceLadder {

    static int N = 30;

    static int minDiceThrows(int move[]) {

        boolean visited[] = new boolean[N];
        Queue<SaLCell> queue = new LinkedList<>();

        SaLCell cell = new SaLCell(0, 0);
        visited[0] = true;
        queue.add(cell);

        // Do a BFS starting from vertex at index 0
        while (!queue.isEmpty()) {

            cell = queue.remove();
            int v = cell.vertex;

            if (v == N - 1)
                break;

            // Otherwise dequeue the front vertex and enqueue its adjacent vertices
            // (or cell numbers reachable through a dice throw)
            for (int j = v + 1; j <= (v + 6) && j < N; ++j) {

                // If this cell is already visited, then ignore
                if (visited[j]) {
                    continue;
                }

                // Check if there is a snake or ladder at 'j'
                // then tail of snake or top of ladder become the adjacent of 'i'
                Integer newVertex = j;
                if (move[j] != -1) {
                    newVertex = move[j];
                }
                visited[j] = true;
                queue.add(new SaLCell(newVertex, cell.diceCount + 1));
            }
        }

        return cell.diceCount;
    }

    public static void main(String[] args) {

        int[] moves = new int[N];
        for (int i = 0; i < N; i++) {
            moves[i] = -1;
        }

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[16] = 3;
        moves[18] = 6;
        moves[20] = 8;
        moves[26] = 0;

        System.out.println("Min Dice throws required is " +
                minDiceThrows(moves));
    }
}
