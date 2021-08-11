package kalva.learnings.ads.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int left = i;
            int product = arr[left];
            while (product < target) {
                List<Integer> pArr = new ArrayList<>();
                for (int j = i; j < left + 1; j++) {
                    pArr.add(arr[j]);
                }
                subarrays.add(pArr);
                if (++left == arr.length) {
                    break;
                }
                product *= arr[left];
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }
}
