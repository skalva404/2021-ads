package kalva.learnings.ads.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Statement#
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: N=2
 * Output: (()), ()()
 * Example 2:
 * <p>
 * Input: N=3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * <p>
 * Solution#
 * This problem follows the Subsets pattern and can be mapped to Permutations. We can follow a similar BFS approach.
 * <p>
 * Let’s take Example-2 mentioned above to generate all the combinations of balanced parentheses. Following a BFS approach, we will keep adding open parentheses ( or close parentheses ). At each step we need to keep two things in mind:
 * <p>
 * We can’t add more than ‘N’ open parenthesis.
 * To keep the parentheses balanced, we can add a close parenthesis ) only when we have already added enough open parenthesis (. For this, we can keep a count of open and close parenthesis with every combination.
 * Following this guideline, let’s generate parentheses for N=3:
 * <p>
 * Start with an empty combination: “”
 * At every step, let’s take all combinations of the previous step and add ( or ) keeping the above-mentioned two rules in mind.
 * For the empty combination, we can add ( since the count of open parenthesis will be less than ‘N’. We can’t add ) as we don’t have an equivalent open parenthesis, so our list of combinations will now be: “(”
 * For the next iteration, let’s take all combinations of the previous set. For “(” we can add another ( to it since the count of open parenthesis will be less than ‘N’. We can also add ) as we do have an equivalent open parenthesis, so our list of combinations will be: “((”, “()”
 * In the next iteration, for the first combination “((”, we can add another ( to it as the count of open parenthesis will be less than ‘N’, we can also add ) as we do have an equivalent open parenthesis. This gives us two new combinations: “(((” and “(()”. For the second combination “()”, we can add another ( to it since the count of open parenthesis will be less than ‘N’. We can’t add ) as we don’t have an equivalent open parenthesis, so our list of combinations will be: “(((”, “(()”, ()("
 * Following the same approach, next we will get the following list of combinations: “((()”, “(()(”, “(())”, “()((”, “()()”
 * Next we will get: “((())”, “(()()”, “(())(”, “()(()”, “()()(”
 * Finally, we will have the following combinations of balanced parentheses: “((()))”, “(()())”, “(())()”, “()(())”, “()()()”
 * We can’t add more parentheses to any of the combinations, so we stop here.
 */
public class GenerateParentheses {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            // if we've reached the maximum number of open and close parentheses, add to the result
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) // if we can add an open parentheses, add it
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
                if (ps.openCount > ps.closeCount) // if we can add a close parentheses, add it
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
            }
        }
        return result;
    }

    public static List<String> generateValidParenthesesR(int num) {
        List<String> result = new ArrayList<>();
        char[] parenthesesString = new char[2 * num];
        generateValidParenthesesRecursive(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private static void generateValidParenthesesRecursive(
            int num, int openCount, int closeCount,
            char[] parentheses, int index, List<String> result) {

        // if we've reached the maximum number of open and close parentheses, add to the result
        if (openCount == num && closeCount == num) {
            result.add(new String(parentheses));
        } else {
            if (openCount < num) { // if we can add an open parentheses, add it
                parentheses[index] = '(';
                generateValidParenthesesRecursive(num, openCount + 1, closeCount, parentheses, index + 1, result);
            }
            if (openCount > closeCount) { // if we can add a close parentheses, add it
                parentheses[index] = ')';
                generateValidParenthesesRecursive(num, openCount, closeCount + 1, parentheses, index + 1, result);
            }
        }
    }

    private static void recursive(int oc, int cc, String str) {
        if (0 == oc && 0 == cc) {
            System.out.println(str);
            return;
        }
        if (oc < cc) {
            recursive(oc, cc - 1, str + ")");
        }
        if (oc > 0) {
            recursive(oc - 1, cc, str + "(");
        }
    }

    public static void main(String[] args) {
//        List<String> result = generateValidParentheses(2);
//        System.out.println("All combinations of balanced parentheses are: " + result);
//
//        result = generateValidParentheses(3);
//        System.out.println("All combinations of balanced parentheses are: " + result);

        List<String> result = generateValidParenthesesR(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        recursive(2, 2, "");
//        result = generateValidParenthesesR(3);
//        System.out.println("All combinations of balanced parentheses are: " + result);
    }

    static class ParenthesesString {
        String str;
        int openCount; // open parentheses count
        int closeCount; // close parentheses count

        public ParenthesesString(String s, int openCount, int closeCount) {
            str = s;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }
}