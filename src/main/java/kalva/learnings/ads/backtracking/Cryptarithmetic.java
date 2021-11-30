package kalva.learnings.ads.backtracking;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Cryptarithmetic {

    public static void solve(String... str) {

        Map<Character, Integer> charToIntMap = Arrays
                .stream(String.join("", str).split(""))
                .collect(Collectors.toMap(x -> x.charAt(0), x -> -1, (v1, v2) -> v1));

        String uniqueChars = String.join("",
                Arrays.stream(String.join("", str).split(""))
                        .collect(Collectors.toSet()));

        boolean[] used = new boolean[10];

        dfs(uniqueChars, 0, charToIntMap, used, str[0], str[1], str[2]);
    }

    private static int getNumbers(String str, Map<Character, Integer> charToIntMap) {
        StringBuilder builder = new StringBuilder();
        for (int l3 = 0; l3 < str.length(); l3++) {
            builder.append(charToIntMap.get(str.charAt(l3)));
        }
        return Integer.parseInt(builder.toString());
    }

    private static void printSolution(Map<Character, Integer> charToIntMap,
                                      String s1, String s2, String s3) {
        System.out.println("=====================");
        for (int l1 = 0; l1 < s1.length(); l1++) {
            System.out.print(s1.charAt(l1) + "(" +
                    charToIntMap.get(s1.charAt(l1)) + ")");
        }
        System.out.println();
        for (int l2 = 0; l2 < s2.length(); l2++) {
            System.out.print(s2.charAt(l2) + "(" +
                    charToIntMap.get(s2.charAt(l2)) + ")");
        }
        System.out.println();
        for (int l3 = 0; l3 < s3.length(); l3++) {
            System.out.print(s3.charAt(l3) + "(" +
                    charToIntMap.get(s3.charAt(l3)) + ")");
        }
        System.out.println();
        System.out.println("=====================");
        System.out.println();
    }

    private static void dfs(String uniqueChars, int index,
                            Map<Character, Integer> charToIntMap,
                            boolean[] used, String s1, String s2, String s3) {

        if (index == uniqueChars.length()) {
            int num1 = getNumbers(s1, charToIntMap);
            int num2 = getNumbers(s2, charToIntMap);
            int num3 = getNumbers(s3, charToIntMap);
            if (num1 + num2 == num3) {
                printSolution(charToIntMap, s1, s2, s3);
            }
            return;
        }

        char current = uniqueChars.charAt(index);
        for (int i = 0; i <= 9; i++) {
            if (used[i]) {
                continue;
            }
            charToIntMap.put(current, i);
            used[i] = true;
            dfs(uniqueChars, index + 1, charToIntMap, used, s1, s2, s3);
            charToIntMap.put(current, -1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        solve("sunil", "kumar", "kalva");
    }
}
