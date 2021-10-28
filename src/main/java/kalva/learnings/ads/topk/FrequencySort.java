package kalva.learnings.ads.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem Statement#
 * Given a string, sort it based on the decreasing frequency of its characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "Programming"
 * Output: "rrggmmPiano"
 * Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
 * Example 2:
 * <p>
 * Input: "abcbab"
 * Output: "bbbaac"
 * Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.
 */
public class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        // find the frequency of each character
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>
                ((e1, e2) -> e2.getValue() - e1.getValue());
        pq.addAll(characterFrequencyMap.entrySet());

        StringBuilder sortedString = new StringBuilder(str.length());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++)
                sortedString.append(entry.getKey());
        }
        return sortedString.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
