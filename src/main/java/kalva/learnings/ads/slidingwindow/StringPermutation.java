package kalva.learnings.ads.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Permutation is defined as the re-arranging of the characters of the string. For example,
 * “abc” has the following six permutations:
 * <p>
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters, it will have n!n! permutations.
 * <p>
 * Example 1:
 * <p>
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * Example 2:
 * <p>
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * Example 3:
 * <p>
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * Example 4:
 * <p>
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 * <p>
 * Solution #
 * This problem follows the Sliding Window pattern, and we can use a similar sliding window strategy as
 * discussed in Longest Substring with K Distinct Characters. We can use a HashMap to remember the frequencies
 * of all characters in the given pattern. Our goal will be to match all the characters from this HashMap
 * with a sliding window in the given string. Here are the steps of our algorithm:
 * <pre>
 * 1. Create a HashMap to calculate the frequencies of all characters in the pattern.
 * 2. Iterate through the string, adding one character at a time in the sliding window.
 * 3. If the character being added matches a character in the HashMap, decrement its frequency in the map.
 *    If the character frequency becomes zero, we got a complete match.
 * 4. If at any time, the number of characters matched is equal to the number of distinct characters
 *    in the pattern (i.e., total characters in the HashMap), we have gotten our required permutation.
 * 5. If the window size is greater than the length of the pattern, shrink the window to make it equal to
 *    the pattern’s size. At the same time, if the character going out was part of the pattern,
 *    put it back in the frequency HashMap.
 */
public class StringPermutation {

    private static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size()) {
                return true;
            }

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
//        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
//        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }
}
