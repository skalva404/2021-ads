package kalva.learnings.ads.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 * <p>
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 * <p>
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class NoRepeatSubstring {

    public static int findLength(String str) {
        int start = 0;
        int size = 0;
        Set<Character> uniq = new HashSet<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character chr = str.charAt(windowEnd);
            if (uniq.contains(chr)) {
                start++;
                size = Math.max(size, uniq.size());
                uniq.clear();
            }
            uniq.add(chr);
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
