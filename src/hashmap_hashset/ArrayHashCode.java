package hashmap_hashset;

import java.util.Arrays;

public class ArrayHashCode {
    public static void main(String[] args) {
        int[] nums1 = {1, 20, 32, 4};
        int[] nums2 = {1, 20, 32, 4};


        int[] test1 = {2, 1};
        int[] test2 = {3, 32};
        int[] test3 = {2, 3};
        int[] test4 = {1, 32};

        System.out.println(Arrays.hashCode(test1));
        System.out.println(Arrays.hashCode(test2));
        System.out.println(Arrays.hashCode(test3));
        System.out.println(Arrays.hashCode(test4));
        /* the hashcode for test1 and test2 are same due to hash collision */

    }
}
