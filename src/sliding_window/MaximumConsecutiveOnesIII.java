package sliding_window;

public class MaximumConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(String.format("Maximium Consecutive Ones giving we can flip %d zeroes: ", k) +
                longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int zeroCount = 0, j = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                while (zeroCount > k) {
                    if (nums[j] == 0) zeroCount--;
                    j++;
                }
            }
            if (i - j + 1 > maxCount) maxCount = i - j + 1;
        }
        return maxCount;
    }
}
