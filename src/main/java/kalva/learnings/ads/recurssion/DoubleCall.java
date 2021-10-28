package kalva.learnings.ads.recurssion;

public class DoubleCall {

    static void demo(int count, boolean flag) {
        if (flag) {
            System.out.println("\tCount = " + count);
        } else {
            System.out.println("Count = " + count);
        }
        if (1 >= count) {
            return;
        }
        demo(count - 1, false);
        demo(count - 2, true);
    }

    public static void main(String[] args) {
        demo(4, false);
    }
}
