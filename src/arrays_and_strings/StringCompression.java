package arrays_and_strings;

import java.util.Arrays;

//leetcode 443
public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println("------Using O(n) space-------");
        System.out.println("Length of compressed array is: " + stringCompress(chars));
        System.out.println("Compressed array is: " + Arrays.toString(chars));
        System.out.println("------Using O(1) space-------");
        System.out.println("Length of compressed array is: " + stringCompressOptimized(chars));
        System.out.println("Compressed array is: " + Arrays.toString(chars));
    }

    private static int stringCompressOptimized(char[] chars) {
        if (chars.length == 1) return 1;
        int start = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) count++;
            else {
                chars[start++] = chars[i - 1];
                if (count > 1) {
                    for (char c : (String.valueOf(count)).toCharArray()) {
                        chars[start++] = c;
                        count = 1;
                    }
                }
            }
            if (i == chars.length - 1) {
                chars[start] = chars[i];
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[++start] = c;
                    }
                }
            }
        }
        return ++start;
    }

    // Space Complexity O(n), Time Complexity O(n)
    public static int stringCompress(char[] chars) {
        if (chars.length == 1) return 1;
        char prev = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) count++;
            else {
                sb.append(prev);
                if (count > 1) sb.append(count);
                prev = chars[i];
                count = 1;
            }
            if (i == chars.length - 1) {
                sb.append(prev);
                if (count > 1) sb.append(count);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
