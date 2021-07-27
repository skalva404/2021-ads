package kalva.learnings.ads.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets,
 * and your goal is to put maximum number of fruits in each basket. The only restriction is that each
 * basket can have only one type of fruit.
 * <p>
 * You can start with any tree, but you can’t skip a tree once you have started. You will pick one
 * fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * <p>
 * Write a function to return the maximum number of fruits in both baskets.
 * <p>
 * Example 1:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * Example 2:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 * <p>
 * Solution #
 * This problem follows the Sliding Window pattern and is quite similar to Longest Substring with K Distinct
 * Characters. In this problem, we need to find the length of the longest subarray with no more than two
 * distinct characters (or fruit types!). This transforms the current problem into Longest Substring with
 * K Distinct Characters where K=2.
 */
public class MaxFruitCountOf2Types {

    public static int findLength(char[] str) {
        int windowSize = 0;
        int windowStart = 0;
        Map<Character, Integer> uniqueCharCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length; windowEnd++) {
            Character c = str[windowEnd];
            uniqueCharCount.put(c, uniqueCharCount.getOrDefault(c, 0) + 1);
            if (2 == uniqueCharCount.size()) {
                windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
            }
            if (2 < uniqueCharCount.size()) {
                c = str[windowStart];
                uniqueCharCount.put(c, uniqueCharCount.get(c) - 1);
                if (0 == uniqueCharCount.get(c)) {
                    uniqueCharCount.remove(c);
                }
                windowStart++;
            }
        }
        return windowSize;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
