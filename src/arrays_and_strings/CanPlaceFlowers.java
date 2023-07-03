package arrays_and_strings;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println("Can place flowers: " + canPlaceFlowers(flowerbed, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) continue;
            if (i != 0 && flowerbed[i - 1] == 1) continue;
            if (i == len - 1) {
                flowerbed[i] = 1;
                n--;
            } else {
                if (flowerbed[i + 1] == 1) continue;
                else {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n == 0) return true;
        }
        return n == 0 ? true : false;
    }
}
