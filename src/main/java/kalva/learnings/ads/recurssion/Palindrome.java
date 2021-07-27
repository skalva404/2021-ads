package kalva.learnings.ads.recurssion;

public class Palindrome {

    static boolean isPalindrome(String str, int l, int r) {

        if (l >= r) {
            return true;
        }
        return str.charAt(l) == str.charAt(r) && isPalindrome(str, l + 1, r - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar", 0, "racecar".length() - 1));
    }
}
