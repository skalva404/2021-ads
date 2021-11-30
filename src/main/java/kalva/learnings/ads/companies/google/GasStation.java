package kalva.learnings.ads.companies.google;

import java.util.Arrays;
import java.util.List;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is arr[i]. You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). At the beginning of the journey, the tank is empty at one of the gas stations.
 * <p>
 * Return the minimum starting gas station’s index if you need to travel around the circuit once, otherwise return -1.
 * <p>
 * Problem Note
 * <p>
 * Completing the circuit means starting at i and ending up at i again.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1
 * <p>
 * Input:
 * arr[] = [1,2,3,4,5]
 * cost[] = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Gas available in Tank = 0 + 4 = 4
 * Travel to station 4.Gas available in tank = 4 - 1 + 5 = 8
 * Travel to station 0.Gas available in tank = 8 - 2 + 1 = 7
 * Travel to station 1.Gas available in tank = 7 - 3 + 2 = 6
 * Travel to station 2.Gas available in tank = 6 - 4 + 3 = 5
 * Travel to station 3.The cost is 5.Your gas is just enough to travel back to station 3.Therefore, return 3 as the starting index.
 * Example 2
 * <p>
 * Input:
 * arr[] = [2,3,4]
 * cost[] = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Gas available in tank = 0 + 4 = 4
 * Travel to station 0.Gas available in tank = 4 - 3 + 2 = 3
 * Travel to station 1.Gas available in tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.Therefore, you can't travel around the circuit once no matter where you start.
 * <p>
 * Solutions
 * We will be discussing a brute force and a greedy solution for the problem
 * <p>
 * Brute Force Solution: Check if you can cover all the gas stations starting from any station. If that’s not possible, repeat it by choosing another starting station.
 * Greedy Solution: Optimize the brute force by concluding that if you cannot cover station B from station A, then any station between them cannot lead to an answer.
 * </p>
 */
public class GasStation {

    /**
     * 1. Brute Force Solution
     * For each station i choose it as a starting point, and try to visit every other station and maintain a fuel to that will tell about the possibility of visiting the next station, if not then choose some other starting station and try to visit until you have reached the starting station.
     * <p>
     * Solution Steps
     * <p>
     * Choose the station as a starting point.
     * Simulate the road trip to see if the following stations are reachable.
     */
    static int bruteForce(int[] gasArry, int[] costArry) {

        for (int i = 0; i < gasArry.length; i++) {
            int counter = 0;
            int currStation = i;
            boolean isAmple = true;
            int gas = gasArry[currStation];
            while (counter < gasArry.length) {
                counter++;
                int nextStation = (currStation + 1) % gasArry.length;
                gas = gas - costArry[currStation];
                System.out.println("" +
                        "From [" + currStation + "] " +
                        "To [" + nextStation + "] " +
                        "Remaining => " + gas);
                currStation = (currStation + 1) % gasArry.length;
                if (gas < 0) {
                    isAmple = false;
                    System.out.println("Can not start from : " + i + "\n");
                    break;
                }
                gas += gasArry[nextStation];
            }
            if (isAmple) {
                System.out.println("Can start from : " + i + "\n");
//                return i;
            }
        }
        return -1;
    }

    /**
     * The problem enables you to have these two ideas:
     * <p>
     * If the car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
     * If the total number of gas is bigger than the total number of cost. There must be a solution.
     * The proof of the above two ideas:
     * <p>
     * In any station between A and B, let’s say C. C will have gas left in our tank, if we go from A to that station. We can’t reach B from A with some gas(maybe 0) left in the tank in C, so we can’t reach B from C with an empty tank.
     * If the gas is more than the cost in total, there must be some stations we have enough gas to go through them. Let’s say they are green stations. So the other stations are red. The adjacent stations with the same color can be joined together as one. Then there must be a red station that can be joined into a precedent green station unless there isn’t any red station because the total gas is more than the total cost. In other words, all of the stations will join into a green station at last.
     * This Concludes:
     * <p>
     * If the sum of gas is more than the sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one you found will the right one).
     * The tank should never be negative, so restart whenever there is a negative number.
     * Solution Steps
     * <p>
     * Create a start to store the valid starting index from where the car could touch all the stations.
     * For each station i, fill the fuel tank with gas[i] and burn the fuel by cost[i]
     * If at any point the tank is < 0 then, choose the next index as the starting point.
     * At last, check if the total fuel available at the gas stations is greater than the total fuel burnt during the travel.
     * Return the start
     * <p>
     * Here is the key thing to keep in mind.
     * <p>
     * 1. If total cost is greater than total amount of gas, there is no way to make a circle travel
     * <p>
     * 2. We have a current remaining which it the remaining amount of gas to start from one of the gas stations.
     * Because there is only one unique solution. For all other gas station, there must be a point that the
     * current remaining is negative which means it cannot start from currently marked station.
     * </p>
     */
    private static int greedyForce(final List<Integer> gas, final List<Integer> cost) {

        int S = 0;
        int surplus = 0;
        int total_surplus = 0;

        for (int i = 0; i < gas.size(); ++i) {
            total_surplus += gas.get(i) - cost.get(i);
            surplus += gas.get(i) - cost.get(i);
            if (surplus < 0) {
                surplus = 0;
                S = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : S;
    }

    public static void main(String[] args) {
        System.out.println(
                greedyForce(
                        Arrays.asList(1, 2, 3, 4, 5),
                        Arrays.asList(3, 4, 5, 1, 2))
        );
    }
}
