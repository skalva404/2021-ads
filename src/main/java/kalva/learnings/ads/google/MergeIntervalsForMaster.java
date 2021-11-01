package kalva.learnings.ads.google;

import kalva.learnings.ads.mergeinnntervals.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.max;

public class MergeIntervalsForMaster {

    static int findCountOfSubsets(List<Interval> intervals, Interval master) {

        List<Interval> found = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));

        boolean completed = false;
        int minD = Integer.MAX_VALUE;
        Interval min = null;
        while (!completed && intervals.size() > 0) {
            for (Iterator<Interval> iterator = intervals.iterator(); iterator.hasNext(); ) {
                Interval interval = iterator.next();
                if (interval.start > master.start || interval.end < master.start) {
                    if (interval.end < master.start) {
                        iterator.remove();
                    }
                    continue;
                }
                int d = interval.end - master.end;
                if (d > 0) {
                    min = interval;
                    completed = true;
                    break;
                }
                if (Math.abs(minD) > Math.abs(d)) {
                    minD = d;
                    min = interval;
                }
            }
            if (null != min) {
//                System.out.println(min);
                found.add(min);
                minD = Integer.MAX_VALUE;
                master = new Interval(max(master.start, min.end) + 1, max(master.end, min.end));
//                System.out.println("\t\t\t" + master);
            }
            min = null;
        }
        return found.size();
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(4, 6));
        intervals.add(new Interval(4, 14));
        intervals.add(new Interval(4, 10));
        intervals.add(new Interval(5, 11));
        intervals.add(new Interval(14, 18));
        intervals.add(new Interval(8, 16));
        intervals.add(new Interval(7, 25));
        System.out.println(findCountOfSubsets(new ArrayList<>(intervals), new Interval(5, 25)));
        System.out.println("====================");
        System.out.println(findCountOfSubsets(new ArrayList<>(intervals), new Interval(5, 23)));
        System.out.println("====================");
        System.out.println(findCountOfSubsets(new ArrayList<>(intervals), new Interval(14, 18)));
        System.out.println("====================");
        System.out.println(findCountOfSubsets(new ArrayList<>(intervals), new Interval(100, 118)));
    }
}
