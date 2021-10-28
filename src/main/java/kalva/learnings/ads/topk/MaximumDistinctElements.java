package kalva.learnings.ads.topk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem Statement#
 * Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [7, 3, 5, 8, 5, 3, 3], and K=2
 * Output: 3
 * Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have to skip 5 because it is not distinct and appeared twice.
 * <p>
 * Another solution could be to remove one instance of '5' and '3' each to be left with three distinct numbers [7, 5, 8], in this case, we have to skip 3 because it appeared twice.
 * Example 2:
 * <p>
 * Input: [3, 5, 12, 11, 12], and K=3
 * Output: 2
 * Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then we can delete any two numbers which will leave us 2 distinct numbers in the result.
 * Example 3:
 * <p>
 * Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
 * Output: 3
 * Explanation: We can remove one occurrence of '4' to get three distinct numbers.
 * <p>
 * Solution#
 * This problem follows the Top ‘K’ Numbers pattern, and shares similarities with Top ‘K’ Frequent Numbers.
 * <p>
 * We can following a similar approach as discussed in Top ‘K’ Frequent Numbers problem:
 * <p>
 * First, we will find the frequencies of all the numbers.
 * Then, push all numbers that are not distinct (i.e., have a frequency higher than one) in a Min Heap based on their frequencies. At the same time, we will keep a running count of all the distinct numbers.
 * Following a greedy approach, in a stepwise fashion, we will remove the least frequent number from the heap (i.e., the top element of the min-heap), and try to make it distinct. We will see if we can remove all occurrences of a number except one. If we can, we will increment our running count of distinct numbers. We have to also keep a count of how many removals we have done.
 * If after removing elements from the heap, we are still left with some deletions, we have to remove some distinct elements.
 */
public class MaximumDistinctElements {

    public static int find(int[] nums, int k) {
        int distinctElementsCount = 0;
        if (nums.length <= k)
            return distinctElementsCount;

        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int i : nums)
            numFrequencyMap.put(i, numFrequencyMap.getOrDefault(i, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));
        // insert all numbers with frequency greater than '1' into the min-heap
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            if (entry.getValue() == 1)
                distinctElementsCount++;
            else
                minHeap.add(entry);
        }
        while (k > 0 && !minHeap.isEmpty()) {
            k -= minHeap.poll().getValue() - 1;
            if (k >= 0)
                distinctElementsCount++;
        }
        // if k > 0, this means we have to remove some distinct numbers
        if (k > 0)
            distinctElementsCount -= k;

        return distinctElementsCount;
    }

    public static void main(String[] args) {
        int result = find(new int[]{7, 3, 5, 8, 5, 3, 3}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = find(new int[]{3, 5, 12, 11, 12}, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = find(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
