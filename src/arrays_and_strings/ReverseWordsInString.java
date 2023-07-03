package arrays_and_strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("Reversed word: " + reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 1) return s;
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i] + (i == 0 ? "" : " "));
        }
        return sb.toString();
    }
}
