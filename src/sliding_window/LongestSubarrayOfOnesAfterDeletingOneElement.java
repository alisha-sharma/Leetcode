package sliding_window;

public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println("Maximum subarray of ones after deleting one element is: " + longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        if (nums.length == 1) return 0;
        int zeroCount = 0, j = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            while (zeroCount > 1) {
                if (nums[j] == 0) zeroCount--;
                j++;
            }
            if (i - j > maxCount) maxCount = i - j;
        }

        return maxCount;

    }
}
