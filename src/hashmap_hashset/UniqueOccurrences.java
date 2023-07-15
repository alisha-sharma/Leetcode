package hashmap_hashset;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 1, 3};

        System.out.println("Result: " + hasUniqueNumberOfOccurrences(nums));
    }

    private static boolean hasUniqueNumberOfOccurrences(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //checking size of map and set
        // HashSet<Integer> set = new HashSet<>(map.values());
        // return map.size() == set.size();

        HashSet<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            if (!set.add(value)) return false;
        }

        return true;
    }
}
