package kalva.learnings.ads.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * <p>
 * Example 1:
 * <p>
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 * Example 2:
 * <p>
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 * <p>
 * Solution#
 * This problem follows the Subsets pattern and can be mapped to Permutations.
 * <p>
 * Let’s take Example-2 mentioned above to generate all the permutations. Following a BFS approach, we will consider one character at a time. Since we need to preserve the character sequence, we can start with the actual string and process each character (i.e., make it upper-case or lower-case) one by one:
 * <p>
 * Starting with the actual string: "ab7c"
 * Processing the first character (‘a’), we will get two permutations: "ab7c", "Ab7c"
 * Processing the second character (‘b’), we will get four permutations: "ab7c", "Ab7c", "aB7c", "AB7c"
 * Since the third character is a digit, we can skip it.
 * Processing the fourth character (‘c’), we will get a total of eight permutations: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 * Let’s analyze the permutations in the 3rd and the 5th step. How can we generate the permutations in the 5th step from the permutations in the 3rd step?
 * <p>
 * If we look closely, we will realize that in the 5th step, when we processed the new character (‘c’), we took all the permutations of the previous step (3rd) and changed the case of the letter (‘c’) in them to create four new permutations.
 */
public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str, int index, List<String> permutations) {
        if (index == str.length()) {
            return permutations;
        }
        if (-1 == index) {
            permutations.add(str);
            return findLetterCaseStringPermutations(str, index + 1, permutations);
        }
        int size = permutations.size();
        for (int i = 0; i < size; i++) {
            String perm = permutations.get(i);
            String s = perm.charAt(index) + "";
            if (isInt(s)) {
                continue;
            }
            String pre = perm.substring(0, index);
            String post = perm.substring(index + 1);
            String cap = s.toUpperCase();
            permutations.add(pre + cap + post);
        }
//        permutations.add(str);
//        permutations.add((str.charAt(in) + "").toUpperCase() + str.substring(i));
        return findLetterCaseStringPermutations(str, index + 1, permutations);
    }

    static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ab7c", -1, new ArrayList<>());
        System.out.println(" String permutations are: ");
        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            System.out.println(s);
        }
    }
}
