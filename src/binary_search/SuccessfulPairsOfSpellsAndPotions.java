package binary_search;

import java.util.*;

/*Time Complexity: O(n + m) (logm)
Space Complexity: O(n)*/
public class SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        //int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        int[] spells = {3, 1, 2}, potions = {8, 5, 8};
        int success = 16;
        System.out.println("Result using brute force: " + Arrays.toString(successfulPairsUsingBruteForce(spells, potions, success)));
        System.out.println("Result using optimized approach: " + Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public static int[] successfulPairsUsingBruteForce(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int count = 0;
            for (int j = 0; j < potions.length; j++) {
                if ((long) spells[i] * (long) potions[j] >= success) count++;
            }
            result[i] = count;
        }
        return result;
    }


    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Olog(mlogm) where m is the length of potions
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long val = spells[i];
            if (val * (long) potions[0] >= success) result[i] = potions.length;
            else if (val * (long) potions[potions.length - 1] < success) result[i] = 0;
            else {
                int res = performBinarySearch(potions, success, spells[i]);
                result[i] = res;
            }
        }
        return result;
    }

    /* Olog(nlogm) where we are performing binary search on potions arrays for each element in spells,
     n = length of spells */
    private static int performBinarySearch(int[] potions, long success, long val) {
        int startIndex = 0;
        int endIndex = potions.length - 1;
        int idx = endIndex + 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (val * (long) potions[mid] >= success) {
                endIndex = mid - 1;
                idx = mid;
            } else {
                startIndex = mid + 1;
            }
        }
        return potions.length - idx;
    }
}
