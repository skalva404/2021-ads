package kalva.learnings.ads.topk;

import java.util.*;

public class KClosestElements {

    static final class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > 0) {
            return low - 1;
        }
        return low;
    }

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X);
        int low = index - K, high = index + K;
        low = Math.max(0, low);
        high = Math.min(high, arr.length - 1);

        PriorityQueue<Entry> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.key));
        for (int i = low; i <= high; i++) {
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
            result.add(arr[Objects.requireNonNull(minHeap.poll()).value]);

        Collections.sort(result);
        return result;
    }

    public static List<Integer> findClosestElementsWTwoPointers(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X);
        int lp = index;
        int rp = index + 1;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (lp >= 0 && rp < arr.length) {
                int d1 = Math.abs(X - arr[lp]);
                int d2 = Math.abs(X - arr[rp]);
                if (d1 <= d2) {
                    result.add(0, arr[lp--]);
                } else {
                    result.add(arr[rp++]);
                }
            } else if (lp >= 0) {
                result.add(0, arr[lp--]);
            } else {
                result.add(arr[rp++]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);
        System.out.println("'K' closest numbers to 'X' are: " + findClosestElementsWTwoPointers(new int[]{5, 6, 7, 8, 9}, 3, 7));

        result = KClosestElements.findClosestElements(new int[]{2, 4, 5, 6, 9}, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[]{2, 4, 5, 6, 9}, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
