package arrays_and_strings;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println("Has triplet sequence: " + increasingTriplet(nums));
    }

    // Time Complexity O(n) and Time Complexity O(1)
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= left) {
                left = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else return true;
        }
        return false;
    }
}
