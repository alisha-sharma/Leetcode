package hashmap_hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        System.out.println(findDifference(nums1, nums2));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for(int num : set1){
            if(set2.contains(num)) set2.remove(num);
            else list1.add(num);
        }

        list.add(list1);
        list.add(new ArrayList<>(set2));

        return list;
    }
}
