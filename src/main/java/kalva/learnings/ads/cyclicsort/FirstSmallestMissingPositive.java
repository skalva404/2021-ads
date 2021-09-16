package kalva.learnings.ads.cyclicsort;

import static kalva.learnings.ads.cyclicsort.MissingNumber.cyclicSort;

/**
 * Find the Smallest Missing Positive Number (medium) #
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 * <p>
 * Example 1:
 * <p>
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 * Example 2:
 * <p>
 * Input: [3, -2, 0, 1, 2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: [3, 2, 5, 1]
 * Output: 4
 * <p>
 * Solution #
 * This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing
 * Number with one big difference. In this problem, the numbers are not bound by any range so
 * we can have any number in the input array.
 * <p>
 * However, we will follow a similar approach though as discussed in Find the Missing Number
 * to place the numbers on their correct indices and ignore all numbers that are out of the range of
 * the array (i.e., all negative numbers and all numbers greater than or equal to the length of the array).
 * Once we are done with the cyclic sort we will iterate the array and the first index that does not have
 * the correct number will be the smallest missing positive number!
 * </p>
 */
public class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {

        cyclicSort(nums);
        System.out.println();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[]{-3, 1, 5, 4, 2}));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[]{3, -2, 0, 1, 2}));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[]{3, 2, 5, 1}));
    }
}
