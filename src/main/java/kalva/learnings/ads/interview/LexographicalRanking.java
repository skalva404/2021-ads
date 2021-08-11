package kalva.learnings.ads.interview;

public class LexographicalRanking {

    static long fact(int n) {
        return (n <= 2) ? n : n * fact(n - 1);
    }

    static int rank(String str) {
        int rank = 1;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    count++;
                }
            }
            rank += count * fact(n - 1 - i);
        }
        return rank;
    }

    public static void main(String[] args) {
        System.out.println(rank("ibytes"));
    }
}
