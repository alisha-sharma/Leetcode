package hashmap_hashset;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindIfTwoStringClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";

        System.out.println("The given two string are close: " + closeString(word1, word2));
        System.out.println("The given two string are close: " + closeStringOptimized(word1, word2));
    }

    private static boolean closeStringOptimized(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] wf1 = new int[26];
        int[] wf2 = new int[26];

        for (char ch : word1.toCharArray()) {
            wf1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            wf2[ch - 'a']++;
        }

        for (int i = 0; i < wf1.length; i++) {
            if (wf1[i] == 0 && wf2[i] != 0 || wf2[i] == 0 && wf1[i] != 0) return false;
        }


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : wf1) {
            if (i > 0) map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : wf2) {
            if (i > 0) {
                if (!map.containsKey(i)) return false;

                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) map.remove(i);
            }
        }

        return map.size() == 0;

    }

    //Space Complexity  - O( m + n)
    //Time Complexity - O(mlogm + nlogn)
    private static boolean closeString(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            if (!map1.containsKey(ch)) return false;
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

        }

        if (map1.size() != map2.size()) return false;

        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());


        return list1.equals(list2);
    }


}
