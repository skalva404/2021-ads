package kalva.learnings.ads.recurssion;

public class PowerSet {

    static void printPowerSet(char[] set) {

        long pow_set_size = (long) Math.pow(2, set.length);
        int counter, j;
        for (counter = 0; counter < pow_set_size; counter++) {
//            System.out.println("Binary is " + Integer.toBinaryString(counter));
            for (j = 0; j < set.length; j++) {
                System.out.print(" " + (counter & (1 << j)) + " ");
//                if ((counter & (1 << j)) > 0)
//                    System.out.print(set[j]);
            }
            System.out.println();
        }
    }

    static void powerSetRecursive1(String str, int index, String curr) {

        if (str.length() == index) {
            System.out.println(curr);
            return;
        }
        powerSetRecursive1(str, index + 1, curr + str.charAt(index));
        powerSetRecursive1(str, index + 1, curr);
    }

    static void powerSetRecursive(String str, int index, String curr) {
        int n = str.length();
        System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            powerSetRecursive(str, i, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        int index = -1;
        String curr = "";

        powerSetRecursive(str, index, curr);
        System.out.println("================");
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set);

        System.out.println("================");
        powerSetRecursive1("abc", 0, "");
    }
}
