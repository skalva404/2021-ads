package kalva.learnings.ads.recurssion;

public class Permutation {

    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    static final void permutation(int start, String str) {
        if (start == str.length() - 1) {
            System.out.println(str);
        }
        for (int i = start; i < str.length(); i++) {
            str = swapString(str, start, i);
            permutation(start + 1, str);
            str = swapString(str, start, i);
        }
    }

    public static void main(String[] args) {
        permutation(0, "abc");
    }
}
