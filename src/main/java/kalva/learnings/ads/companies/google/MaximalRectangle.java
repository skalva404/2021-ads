package kalva.learnings.ads.companies.google;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 */
public class MaximalRectangle {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList(Arrays.asList(0, 1, 1, 0)));
        A.add(new ArrayList(Arrays.asList(1, 1, 1, 1)));
        A.add(new ArrayList(Arrays.asList(1, 1, 1, 1)));
        A.add(new ArrayList(Arrays.asList(1, 1, 0, 0)));
        System.out.print("Area of maximum rectangle is " + maxRectangle(A));
    }

    private static int maxRectangle(ArrayList<ArrayList<Integer>> a) {
        int maxArea = LargestRectInHisto.getMaxArea(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (1 == a.get(i).get(j)) {
                    a.get(i).set(j, a.get(i - 1).get(j) + a.get(i).get(j));
                }
                maxArea = Math.max(maxArea, LargestRectInHisto.getMaxArea(a.get(i)));
            }
        }
        return maxArea;
    }
}
