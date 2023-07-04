package two_pointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("------Using Two Pointers---------");
        moveZeroesUsingTwoPointers(nums);
        System.out.println("Resultant array: " + Arrays.toString(nums));
        System.out.println("------Using Single Pointer--------");
        moveZeroesUsingSinglePointer(nums);
        System.out.println("Resultant array: " + Arrays.toString(nums));
    }

    //using two pointer
    public static void moveZeroesUsingTwoPointers(int[] nums) {
        if (nums.length == 1) return;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) return;
            if (nums[i] == 0) {
                if(nums[i + 1] != 0) {
                    nums[start] = nums[i + 1];
                    nums[i + 1] = 0;
                    start++;
                }
            } else start++;
        }
    }

    public static void moveZeroesUsingSinglePointer(int[] nums){
        if(nums.length == 1) return;
        int start = 0;
        for(int num : nums){
            if(num != 0){
                nums[start] = num;
                start++;
            }
        }
        while(start < nums.length){
            nums[start++] = 0;
        }
    }
}
