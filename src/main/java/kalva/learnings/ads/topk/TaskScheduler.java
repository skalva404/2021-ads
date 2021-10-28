package kalva.learnings.ads.topk;

import java.util.*;

/**
 * Scheduling Tasks (hard)#
 * You are given a list of tasks that need to be run, in any order, on a server. Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which it can’t be run again. If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.
 * <p>
 * If at any time the server can’t execute any task then it must stay idle.
 * <p>
 * Example 1:
 * <p>
 * Input: [a, a, a, b, c, c], K=2
 * Output: 7
 * Explanation: a -> c -> b -> a -> c -> idle -> a
 * Example 2:
 * <p>
 * Input: [a, b, a], K=3
 * Output: 5
 * Explanation: a -> b -> idle -> idle -> a
 */
public class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {

        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char chr : tasks)
            taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all tasks to the max heap
        maxHeap.addAll(taskFrequencyMap.entrySet());

        int intervalCount = 0;
        while (!maxHeap.isEmpty()) {
            int n = k + 1;
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            for (; n > 0 && !maxHeap.isEmpty(); n--) {
                intervalCount++;
                Map.Entry<Character, Integer> poll = maxHeap.poll();
                if (poll.getValue() > 1) {
                    poll.setValue(poll.getValue() - 1);
                    waitList.add(poll);
                }
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty())
                intervalCount += n;
        }
        return intervalCount;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'a', 'a', 'a', 'b', 'c', 'c'};
        System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 2));

        tasks = new char[]{'a', 'b', 'a'};
        System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 3));
    }
}
