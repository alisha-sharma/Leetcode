package arrays_and_strings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4} )));
        System.out.println(Arrays.toString(productExceptSelfOptimized(new int[]{1, 2, 3, 4})));
    }

    private static int[] productExceptSelfOptimized(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int result = 1;
        answer[0] = result;
        for (int i = 1; i < len; i++) {
            result *= nums[i - 1];
            answer[i] = result;
        }
        result = 1;
        for (int j = len - 2; j >= 0; j--) {
            result *= nums[j + 1];
            answer[j] *= result;
        }
        return answer;
    }

    // using simple approach
    private static int[] productExceptSelf(int[] nums) {
        int j = 0;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int result = 1;
            while (j < nums.length) {
                if (j != i) {
                    result *= nums[j];
                }
                j++;
            }
            answer[i] = result;
            j = 0;
        }
        return answer;
    }
}
