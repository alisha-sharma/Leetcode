package two_pointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println("Result: " + isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() != 0 && s.length() == 0) return false;
        int j = 0;
        for (int i = 0; j < s.length() && i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) return true;
        }
        return false;
    }
}
