package kalva.learnings.ads.recurssion;

public class Demo {

    static void bin(int n) {
        /* step 1 */
        if (n > 1)
            bin(n / 2);

        /* step 2 */
        System.out.print(n % 2);
    }

    // Driver code
    public static void main(String[] args) {
//        bin(1);
//        System.out.println();
//        bin(4);
        System.out.println(3 & 1);
        System.out.println(3 & 2);
        System.out.println(3 & 4);
    }
}
