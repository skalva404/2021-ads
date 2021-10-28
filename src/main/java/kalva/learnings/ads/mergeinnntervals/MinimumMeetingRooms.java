package kalva.learnings.ads.mergeinnntervals;

import java.util.*;

/**
 * Minimum Meeting Rooms (hard) #
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 * <p>
 * Example 1:
 * <p>
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:
 * <p>
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * Example 3:
 * <p>
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.
 * <p>
 * Example 4:
 * <p>
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 * <p>
 * Here is a visual representation of Example 4:
 *
 * <p>
 * Solution #
 * Let’s take the above-mentioned example (4) and try to follow our Merge Intervals approach:
 * <p>
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * <p>
 * Step 1: Sorting these meetings on their start time will give us: [[2,3], [2,4], [3,5], [4,5]]
 * <p>
 * Step 2: Merging overlapping meetings:
 * <p>
 * [2,3] overlaps with [2,4], so after merging we’ll have => [[2,4], [3,5], [4,5]]
 * [2,4] overlaps with [3,5], so after merging we’ll have => [[2,5], [4,5]]
 * [2,5] overlaps [4,5], so after merging we’ll have => [2,5]
 * Since all the given meetings have merged into one big meeting ([2,5]), does this mean that they all are overlapping and
 * we need a minimum of four rooms to hold these meetings? You might have already guessed that the answer is NO!
 * As we can clearly see, some meetings are mutually exclusive. For example, [2,3] and [3,5] do not overlap and can happen in one room.
 * So, to correctly solve our problem, we need to keep track of the mutual exclusiveness of the overlapping meetings.
 * <p>
 * Here is what our strategy will look like:
 * <p>
 * We will sort the meetings based on start time.
 * We will schedule the first meeting (let’s call it m1) in one room (let’s call it r1).
 * If the next meeting m2 is not overlapping with m1, we can safely schedule it in the same room r1.
 * If the next meeting m3 is overlapping with m2 we can’t use r1, so we will schedule it in another room (let’s call it r2).
 * Now if the next meeting m4 is overlapping with m3, we need to see if the room r1 has become free. For this, we need to keep track of the end time of the meeting happening in it. If the end time of m2 is before the start time of m4, we can use that room r1, otherwise, we need to schedule m4 in another room r3.
 * We can conclude that we need to keep track of the ending time of all the meetings currently happening so that when we try to schedule a new meeting, we can see what meetings have already ended. We need to put this information in a data structure that can easily give us the smallest ending time. A Min Heap would fit our requirements best.
 * <p>
 * So our algorithm will look like this:
 * <p>
 * Sort all the meetings on their start time.
 * Create a min-heap to store all the active meetings. This min-heap will also be used to find the active meeting with the smallest end time.
 * Iterate through all the meetings one by one to add them in the min-heap. Let’s say we are trying to schedule the meeting m1.
 * Since the min-heap contains all the active meetings, so before scheduling m1 we can remove all meetings
 * from the heap that have ended before m1, i.e., remove all meetings from the heap that have an end time smaller than or equal to the start time of m1.
 * Now add m1 to the heap.
 * The heap will always have all the overlapping meetings, so we will need rooms for all of them.
 * Keep a counter to remember the maximum size of the heap at any time which will be the minimum number of rooms needed.
 * </p>
 */
public class MinimumMeetingRooms {

    public static int findMinimumIntervalRooms(List<Interval> meetings) {

        // sort the meetings by start time
        meetings.sort(Comparator.comparingInt(a -> a.start));

        int minRooms = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(a -> a.end));

        for (Interval interval : meetings) {
            // remove all meetings that have ended
            while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            minHeap.offer(interval);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumIntervalRooms(input);
        System.out.println("Minimum Rooms rooms required: " + result);

//        input = new ArrayList<Interval>() {
//            {
//                add(new Interval(1, 4));
//                add(new Interval(2, 5));
//                add(new Interval(7, 9));
//            }
//        };
//        result = MinimumMeetingRooms.findMinimumIntervalRooms(input);
//        System.out.println("Minimum Rooms rooms required: " + result);
//
//        input = new ArrayList<Interval>() {
//            {
//                add(new Interval(6, 7));
//                add(new Interval(2, 4));
//                add(new Interval(8, 12));
//            }
//        };
//        result = MinimumMeetingRooms.findMinimumIntervalRooms(input);
//        System.out.println("Minimum Rooms rooms required: " + result);
//
//        input = new ArrayList<Interval>() {
//            {
//                add(new Interval(1, 4));
//                add(new Interval(2, 3));
//                add(new Interval(3, 6));
//            }
//        };
//        result = MinimumMeetingRooms.findMinimumIntervalRooms(input);
//        System.out.println("Minimum Rooms rooms required: " + result);
//
//        input = new ArrayList<Interval>() {
//            {
//                add(new Interval(4, 5));
//                add(new Interval(2, 3));
//                add(new Interval(2, 4));
//                add(new Interval(3, 5));
//            }
//        };
//        result = MinimumMeetingRooms.findMinimumIntervalRooms(input);
//        System.out.println("Minimum Rooms rooms required: " + result);
    }
}
