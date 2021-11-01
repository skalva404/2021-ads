package kalva.learnings.ads.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectInHisto {

    public static void main(String[] args) {
        ArrayList<Integer> hist = new ArrayList(Arrays.asList(6, 2, 5, 4, 5, 1, 6));
//        ArrayList<Integer> hist = new ArrayList(Arrays.asList(0, 1, 1, 0));
        System.out.println("Maximum area is " + getMaxArea(hist));
    }

    public static int getMaxArea(ArrayList<Integer> hist) {

        int maxArea = 0; // Initialize max area
        Stack<Integer> s = new Stack<>();
        int ctr = 0;
        while (ctr < hist.size()) {
            if (s.empty() || hist.get(s.peek()) <= hist.get(ctr)) {
                s.push(ctr++);
            } else {
                maxArea = compute(hist, maxArea, s, ctr);
            }
        }

        while (!s.empty()) {
            maxArea = compute(hist, maxArea, s, ctr);
        }
        return maxArea;
    }

    private static int compute(ArrayList<Integer> hist, int maxArea, Stack<Integer> s, int ctr) {
        int tp = s.pop();
        int count = s.empty() ? ctr : ctr - s.peek() - 1;
        return Math.max(maxArea, hist.get(tp) * count);
    }
}