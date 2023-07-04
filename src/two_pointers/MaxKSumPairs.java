package two_pointers;

import java.util.Arrays;
import java.util.HashMap;

public class MaxKSumPairs {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println("----Using HashMap----");
        System.out.println("Max number of operations: " + maxOperationsUsingHashMap(nums, k));
        System.out.println("----Using Two pointers----");
        System.out.println("Max number of operations: " + maxOpertionsUsingTwoPointers(nums, k));
    }

    private static int maxOpertionsUsingTwoPointers(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int operations = 0;
        while (start < end) {
            if (nums[start] + nums[end] == k) {
                operations++;
                start++;
                end--;
            } else if (nums[start] + nums[end] < k) {
                start++;
            } else end--;
        }
        return operations;
    }

    public static int maxOperationsUsingHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if (map.containsKey(diff)) {
                map.put(diff, map.get(diff) - 1);
                operations++;
                if (map.get(diff) == 0) map.remove(diff);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return operations;
    }
}
