package kalva.learnings.ads.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * You can assume that K is less than or equal to the length of the given string.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {

        int windowSize = 0;
        int windowStart = 0;
        Map<Character, Integer> uniqueCharCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character c = str.charAt(windowEnd);
            uniqueCharCount.put(c, uniqueCharCount.getOrDefault(c, 0) + 1);
            if (k == uniqueCharCount.size()) {
                windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
            }
            if (k < uniqueCharCount.size()) {
                char leftChar = str.charAt(windowStart);
                uniqueCharCount.put(leftChar, uniqueCharCount.get(leftChar) - 1);
                if (uniqueCharCount.get(leftChar) == 0) {
                    uniqueCharCount.remove(leftChar);
                }
                windowStart++;
            }
        }
        return windowSize;
    }

    public static void main(String[] args) {

        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
    }
}
