package kalva.learnings.ads.twopointer;

/**
 * Comparing Strings containing Backspaces (medium) #
 * Given two strings containing backspaces (identified by the character ‘#’),
 * check if the two strings are equal.
 * <p>
 * Example 1:
 * <p>
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 * <p>
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 * <p>
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * Example 4:
 * <p>
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class BackspaceCompare {

//    private static boolean compare(String str1, String str2) {
//        return replacedString(str1).equals(replacedString(str2));
//    }

    private static String replacedString(String str1) {
        int p = 0, n = 1;
        StringBuilder builder = new StringBuilder();
        while (n < str1.length()) {
            if ('#' != str1.charAt(p) && '#' != str1.charAt(n)) {
                builder.append(str1.charAt(p));
            }
            p++;
            n++;
        }
        if ('#' != str1.charAt(p)) {
            builder.append(str1.charAt(p));
        }
        System.out.println(builder);
        return builder.toString();
    }

    public static boolean compare(String str1, String str2) {

        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            index1 = getNextValidCharIndex(str1, index1);
            index2 = getNextValidCharIndex(str2, index2);
            if (str1.charAt(index1) != str2.charAt(index2)) {
                return false;
            }
            index1--;
            index2--;
        }
        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int valid = index;
        int backspaces = 0;
        while (valid >= 0) {
            if (str.charAt(valid) == '#') {
                backspaces++;
            } else {
                break;
            }
            valid--;
        }
        return index - 2 * backspaces;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xyz##", "xp#"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}
