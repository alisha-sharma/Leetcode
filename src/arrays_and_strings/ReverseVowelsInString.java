package arrays_and_strings;

public class ReverseVowelsInString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("Resultant String: " + reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;

        StringBuilder sb = new StringBuilder(s);

        while (start < end) {
            char sChar = sb.charAt(start);
            char eChar = sb.charAt(end);
            if (!isVowel(Character.toLowerCase(sChar))) start++;
            if (!isVowel(Character.toLowerCase(eChar))) end--;
            if (isVowel(Character.toLowerCase(sChar)) && isVowel(Character.toLowerCase(eChar))) {
                //switch characters
                sb.setCharAt(start, eChar);
                sb.setCharAt(end, sChar);
                start++;
                end--;
            }
        }

        return sb.toString();

    }

    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
