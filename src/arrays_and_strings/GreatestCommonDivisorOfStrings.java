package arrays_and_strings;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println("The greatest common divisor is: " + gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.charAt(0) != str2.charAt(0)) return "";
        if (!(str1 + str2).equals(str2 + str1)) return "";

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
