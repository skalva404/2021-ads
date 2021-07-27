package kalva.learnings.ads.recurssion;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    static Set<String> powerSetList(String str) {

        Set<String> set = new HashSet<>();

        return set;
    }

    //Using binary conversion
    static void printPowerSet(char[] set, int set_size) {

        long pow_set_size = (long) Math.pow(2, set_size);
        int counter, j;
        for (counter = 0; counter < pow_set_size; counter++) {
            for (j = 0; j < set_size; j++) {
                if ((counter & (1 << j)) > 0)
                    System.out.print(set[j]);
            }
            System.out.println();
        }
    }

    static void powerSetRecursive(String str, int index, String curr) {
        int n = str.length();
        System.out.println(curr);
//        System.out.println(index + "  " + curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            powerSetRecursive(str, i, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    static void print(int index, String str) {
        for (int i = index; i <= index; i++) {
            System.out.print("\t\t");
        }
        System.out.println(index + "  " + str);
    }

    // Driver code
    public static void main(String[] args) {
        String str = "abc";
        int index = -1;
        String curr = "";

        powerSetRecursive(str, index, curr);
        System.out.println("================");
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
    }
}
