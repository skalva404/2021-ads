package kalva.learnings.ads.companies.thoughtspot;

public class LongOperations {

    static String longDivision(String number, int divisor) {

        StringBuilder result = new StringBuilder();
        char[] dividend = number.toCharArray();

        int carry = 0;
        for (char c : dividend) {
            int x = carry * 10 + Character.getNumericValue(c);
            result.append(x / divisor);
            carry = x % divisor;
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result.substring(i);
            }
        }
        return "";
    }

    static String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }

        int result[] = new int[len1 + len2];
        int i_n1 = 0;
        int i_n2 = 0;

        // Go from right to left in num1
        for (int i = len1 - 1; i >= 0; i--) {

            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {

                // Take current digit of second number
                int n2 = num2.charAt(j) - '0';

                // Multiply with current digit of first number
                // and add result to previously stored result
                // charAt current position.
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

                // Carry for next itercharAtion
                carry = sum / 10;

                // Store result
                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }

            if (carry > 0) {
                result[i_n1 + i_n2] += carry;
            }
            i_n1++;
        }

        // ignore '0's from the right
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }

        // If all were '0's - means either both
        // or one of num1 or num2 were '0'
        if (i == -1) {
            return "0";
        }

        // genercharAte the result String
        StringBuilder s = new StringBuilder();

        while (i >= 0) {
            s.append(result[i--]);
        }

        return s.toString();
    }

    static String findSum(String str1, String str2) {

        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        StringBuilder str = new StringBuilder();
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of Strings
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {

            int sum = ((str1.charAt(i) - '0') +
                    (str2.charAt(i) - '0') + carry);
            str.insert(0, (char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++) {
            int sum = ((str2.charAt(i) - '0') + carry);
            str.insert(0, (char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0) {
            str.insert(0, (char) (carry + '0'));
        }
        return str.toString();
    }

    static boolean isSmaller(String str1, String str2) {
        // Calculate lengths of both string
        int n1 = str1.length(), n2 = str2.length();
        if (n1 < n2)
            return true;
        if (n2 < n1)
            return false;

        for (int i = 0; i < n1; i++)
            if (str1.charAt(i) < str2.charAt(i))
                return true;
            else if (str1.charAt(i) > str2.charAt(i))
                return false;

        return false;
    }

    static String findDiff(String str1, String str2) {
        if (isSmaller(str1, str2)) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        StringBuilder str = new StringBuilder();
        int n1 = str1.length(), n2 = str2.length();
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n2; i++) {
            int sub
                    = (str1.charAt(i) - '0'
                    - (str2.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else
                carry = 0;
            str.insert(0, (char) (sub + '0'));
        }

        for (int i = n2; i < n1; i++) {
            int sub = (str1.charAt(i) - '0' - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else
                carry = 0;
            str.insert(0, (char) (sub + '0'));
        }

        return str.toString();
    }

    public static void main(String[] args) {

        String number = "1248163264128256512";
        int divisor = 125;
        System.out.println("longDivision = " + longDivision(number, divisor));

        String str1 = "1235421415454545454545454544";
        String str2 = "1714546546546545454544548544544545";
        System.out.println("multiply = " + multiply(str1, str2));

        str1 = "198111";
        str2 = "12";
        System.out.println("findSum = " + findSum(str1, str2));

        str1 = "978";
        str2 = "12977";
        System.out.println("findDiff = " + findDiff(str1, str2));
    }
}
