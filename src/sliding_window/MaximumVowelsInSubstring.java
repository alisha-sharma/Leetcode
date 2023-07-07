package sliding_window;

public class MaximumVowelsInSubstring {
    public static void main(String[] args) {
        String s = "aeiou";
        int k = 2;
        System.out.println("Maximum number of vowels in a substring of the given string is: "
                + maxVowelsUsingIntArray(s, k));
        System.out.println("Maximum number of vowels in a substring of the given string is: "
                + maxVowelsUsingByteArray(s, k));
    }

    // using byte array occupies 1 byte for each element
    private static int maxVowelsUsingByteArray(String s, int k) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        byte[] vowels = new byte['z' + 1];
        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            count += vowels[chars[i]];
        }
        maxCount = count;
        for (int i = k; i < chars.length; i++) {
            count += vowels[chars[i]] - vowels[chars[i - k]];
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }

    // using int array occupies 2byte for each element
    public static int maxVowelsUsingIntArray(String s, int k) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        int[] vowels = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowels[i] = 1;
        }

        for (int i = 0; i < k; i++) {
            count += vowels[i];
        }
        maxCount = count;
        System.out.println(maxCount);
        for (int i = k; i < chars.length; i++) {
            count += vowels[i] - vowels[i - k];
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }
}
