package arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class GreatestCandies {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println("Resulting boolean array: " + (kidsWithCandies(candies, extraCandies)));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int len = candies.length;
        int max = candies[0];
        for (int i = 1; i < len; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else result.add(false);
        }
        return result;
    }
}
