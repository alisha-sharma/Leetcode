package sliding_window;

public class MaximumAverageSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(String.format("Max Average of consecutive %s elements in the given array is: " +
                findMaxAverage(nums, k), k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        int globalMax = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        globalMax = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            if (windowSum > globalMax) {
                globalMax = windowSum;
            }
        }
        return globalMax / 1.0d / k;
    }
}
