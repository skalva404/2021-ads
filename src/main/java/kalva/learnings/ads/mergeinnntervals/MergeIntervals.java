package kalva.learnings.ads.mergeinnntervals;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a
 * list that has only mutually exclusive intervals.
 * <p>
 * Example 1:
 * <p>
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 * <p>
 *
 * </p>
 */
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> input) {

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        input.sort(Comparator.comparingInt(o -> o.start));
        Iterator<Interval> iterator = input.iterator();
        Interval current = iterator.next();
        int pStart = current.start;
        int pEnd = current.end;

        while (iterator.hasNext()) {
            current = iterator.next();
            if (current.start <= pEnd) {
                pEnd = Math.max(pEnd, current.end);
            } else {
                mergedIntervals.add(new Interval(pStart, pEnd));
                pStart = current.start;
                pEnd = current.end;
            }
        }
        mergedIntervals.add(new Interval(pStart, pEnd));
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}