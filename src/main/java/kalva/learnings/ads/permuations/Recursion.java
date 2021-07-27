package kalva.learnings.ads.permuations;

public class Recursion {

    //https://www.youtube.com/watch?v=sPAT_DbvDj0
    public static void printAllRecursive(String ques, String sofar) {

        if (0 == ques.length()) {
            System.out.println(sofar);
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String l = ques.substring(0, i);
            String r = ques.substring(i + 1);
            printAllRecursive(l + r, sofar + ch);
        }
    }

    public static <T> void printAllRecursive(int cid, T[] elements) {
        if (elements.length - 1 == cid) {
            printArray(elements);
        }
        for (int i = cid; i < elements.length; i++) {
            swap(elements, cid, i);
            printAllRecursive(cid + 1, elements);
            swap(elements, cid, i);
        }
    }

    private static <T> void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static <T> void printArray(T[] input) {
        for (T t : input) {
            System.out.print(t);
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
//        printAllRecursive("abc", "");
        System.out.println("============");
        printAllRecursive(0, new Character[]{'a', 'b', 'c'});
    }
}
