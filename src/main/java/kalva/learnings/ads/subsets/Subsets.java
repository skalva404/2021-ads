package kalva.learnings.ads.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * To generate all subsets of the given set, we can use the Breadth First Search (BFS) approach. We can start with an empty set, iterate through all numbers one-by-one, and add them to existing sets to create new subsets.
 * <p>
 * Let’s take the example-2 mentioned above to go through each step of our algorithm:
 * <p>
 * Given set: [1, 5, 3]
 * <p>
 * Start with an empty set: [[]]
 * Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
 * Add the second number (5) to all the existing subsets: [[], [1], [5], [1,5]];
 * Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]].
 * Here is the visual representation of the above steps:
 */
public class Subsets {

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[]{1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[]{1, 5, 3});
        System.out.println("Here is the list of subsets: " + result);
    }

    private static List<List<Integer>> findSubsets(int[] ints) {

        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int anInt : ints) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> integers = subsets.get(i);
                ArrayList<Integer> newList = new ArrayList<>(integers);
                newList.add(anInt);
                subsets.add(newList);
            }
        }
        return subsets;
    }
}
