package kalva.learnings.ads.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words, find all the starting indices of substrings in the given string
 * that are a concatenation of all the given words exactly once without any overlapping of words.
 * It is given that all words are of the same length.
 * <p>
 * Example 1:
 * <p>
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 * Example 2:
 * <p>
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 * <p>
 * Solution
 * This problem follows the Sliding Window pattern and has a lot of similarities with
 * Maximum Sum Subarray of Size K. We will keep track of all the words in a HashMap and try to match
 * them in the given string. Here are the set of steps for our algorithm:
 * <p>
 * Keep the frequency of every word in a HashMap.
 * Starting from every index in the string, try to match all the words.
 * In each iteration, keep track of all the words that we have already seen in another HashMap.
 * If a word is not found or has a higher frequency than required, we can move on to the next character
 * in the string.
 * Store the index if we have found all the words.
 */
public class WordConcatenation {

    public static List<Integer> findWordConcatenation(String str, String[] words) {

        Map<String, Integer> patternCount = new HashMap<>();
        for (String word : words) {
            patternCount.put(word, patternCount.getOrDefault(word, 0) + 1);
        }

        int windowStart = 0;
        String word;
        for (int i = 0; i < str.length(); i++) {
            word = str.substring(windowStart, i);
            if (patternCount.containsKey(word)) {
                windowStart++;
                patternCount.put(word, patternCount.get(word) - 1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> result = findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"});
        System.out.println(result);
    }
}
