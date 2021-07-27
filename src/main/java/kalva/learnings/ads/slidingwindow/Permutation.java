package kalva.learnings.ads.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    // Iterative function to generate all permutations of a string in Java
    // using Collections
    private static void permutations(String originalStr) {

        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();
        // initialize the list with the first character of the string
        partial.add(String.valueOf(originalStr.charAt(0)));

        // do for every character of the specified string
        for (int i = 1; i < originalStr.length(); i++) {
            // consider previously constructed partial permutation one by one
            // (iterate backward to avoid ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0; j--) {
                // removeFromSortedArry current partial permutation from the ArrayList
                String str = partial.remove(j);
                // Insert the next character of the specified string at all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed strings in the list
                for (int k = 0; k <= str.length(); k++) {
                    // Advice: use StringBuilder for concatenation
                    partial.add(str.substring(0, k) + originalStr.charAt(i) + str.substring(k));
                }
            }
        }
        System.out.println(partial);
    }

    // Iterative program to generate all permutations of a string in Java
    public static void main(String[] args) {
        String s = "ABC";
        permutations(s);
    }
}
