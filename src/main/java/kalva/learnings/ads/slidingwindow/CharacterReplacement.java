package kalva.learnings.ads.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
 * letters with any letter, find the length of the longest substring having the same letters after
 * replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:
 * <p>
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:
 * <p>
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class CharacterReplacement {

    public static int findLength(String str, int k) {

        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            char c = str.charAt(windowEnd);
            letterFrequencyMap.put(c, letterFrequencyMap.getOrDefault(c, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(c));
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                c = str.charAt(windowStart);
                windowStart++;
                letterFrequencyMap.put(c, letterFrequencyMap.get(c) - 1);
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("baegiaf", 2));
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
//        System.out.println(CharacterReplacement.findLength("abbcb", 1));
//        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
