package kalva.learnings.ads.topk;

import java.util.PriorityQueue;

/**
 * Problem Statement#
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 * <p>
 * The class should have the following two things:
 * <p>
 * The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
 * The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 * Example 1:
 * <p>
 * Input: [3, 1, 5, 12, 2, 11], K = 4
 * 1. Calling add(6) should return '5'.
 * 2. Calling add(13) should return '6'.
 * 2. Calling add(4) should still return '6'.
 */
public class KthLargestNumberInStream {

    int k;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargestNumberInStream(int[] input, int k) {
        this.k = k;
        for (int i1 : input) {
            queue.add(i1);
        }
    }

    private int add(int i) {
        queue.add(i);
        while(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
