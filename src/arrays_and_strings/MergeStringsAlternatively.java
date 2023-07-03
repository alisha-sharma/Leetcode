package arrays_and_strings;

public class MergeStringsAlternatively {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println("The merged string is: " + mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
            i++;
        }
        str.append(word1.substring(i));
        str.append(word2.substring(i));

        return str.toString();
    }
}
