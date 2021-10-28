package kalva.learnings.ads.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Evaluate Expression (hard) #
 * Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: "1+2*3"
 * Output: 7, 9
 * Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
 * Example 2:
 * <p>
 * Input: "2*3-4-5"
 * Output: 8, -12, 7, -7, -3
 * Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => -3
 * <p>
 * Solution #
 * This problem follows the Subsets pattern and can be mapped to Balanced Parentheses. We can follow a similar BFS approach.
 * <p>
 * Let’s take Example-1 mentioned above to generate different ways to evaluate the expression.
 * <p>
 * We can iterate through the expression character-by-character.
 * we can break the expression into two halves whenever we get an operator (+, -, *).
 * The two parts can be calculated by recursively calling the function.
 * Once we have the evaluation results from the left and right halves, we can combine them to produce all results.
 */
public class EvaluateExpression {

    private static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        if (isDigit(input)) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isDigit(c)) {
                    continue;
                }
                List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i));
                List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));
//                System.out.println(c + " " + left + "  " + right);
                for (int part1 : left) {
                    for (int part2 : right) {
                        compute(result, c, part1, part2);
                    }
                }
            }
        }
//        System.out.println(result);
        return result;
    }

    private static boolean isDigit(String input) {
        return (!input.contains("+") && !input.contains("-") && !input.contains("*"));
    }

    private static void compute(List<Integer> result, char chr, int part1, int part2) {
        if (chr == '+')
            result.add(part1 + part2);
        else if (chr == '-')
            result.add(part1 - part2);
        else if (chr == '*')
            result.add(part1 * part2);
//        if (result.contains(-6)) {
//            System.out.println("\t\t" + chr + " " + part1 + "  " + part2);
//        }
    }

    public static void main(String[] args) {
//        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
//        System.out.println("Expression evaluations: " + result);

        List<Integer> result1 = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result1);
    }
}
