package kalva.learnings.ads.arrays;

import java.util.*;

import static java.util.Arrays.copyOfRange;

public class MaxSumSubArray {

    public static void main(String[] args) {

        Integer[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kadane(A));
        System.out.println(sumArrayTopDown(A));
        System.out.println(kadane(new Integer[]{1, 2, -3, -4, 2, 7, -2, 3}));
        System.out.println(sumArrayTopDown(new Integer[]{1, 2, -3, -4, 2, 7, -2, 3}));
    }

    private static List<Integer> sumArrayTopDown(Integer[] a) {
        int maxSoFar = 0;
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = a.length - 1; i > 0; i--) {
            int ctr = i;
            while (ctr < a.length) {
                int maxEndingHere = 0;
                for (int j = i; j <= ctr; j++) {
                    String key = j + ":" + ctr;
                    Integer value = map.get(key);
                    if (null != value) {
                        maxEndingHere += value;
                        break;
                    } else {
                        maxEndingHere += a[j];
                    }
                }
                if (maxEndingHere > maxSoFar) {
                    maxSoFar = maxEndingHere;
                    list = Arrays.asList(copyOfRange(a, i, ctr + 1));
//                    System.out.println(maxEndingHere + " : " + maxSoFar + " : " + list);
                }
                map.put(i + ":" + ctr, maxEndingHere);
                ctr++;
            }
        }
        return list;
    }

    private static int kadane(Integer[] a) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i1 : a) {
            maxEndingHere += i1;
            maxEndingHere = Integer.max(maxEndingHere, 0);
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
