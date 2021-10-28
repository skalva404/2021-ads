package kalva.learnings.ads.xor;

public class SingleNumber {
    private static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int value : arr) {
            num = num ^ value;
        }
        return num;
    }

    public static void main(String args[]) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
