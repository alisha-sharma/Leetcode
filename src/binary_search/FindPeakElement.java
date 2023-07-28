package binary_search;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index is: " + findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
                ;
            }
        }

        return start;
    }
}
