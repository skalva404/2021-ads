package kalva.learnings.ads.google;

import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Thoughts:
 * Use a counter for currently met element. Since the major element will eventually win no matter where it starts.
 */
public class MjorityElement {

    public static int majorityElement(final List<Integer> nums) {
        int counter = 1;
        int candidate = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (0 == counter) {
                counter = 1;
                candidate = nums.get(i);
            } else {
                if (nums.get(i) == candidate) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(Arrays.asList(2, 1, 1)));
//        System.out.println(majorityElement(Arrays.asList(3, 3, 3, 1, 7, 8, 3, 9, 3, 4)));
    }
}
