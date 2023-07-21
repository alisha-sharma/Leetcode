package binary_search;

public class GuessNumber {
    static long pick = 19;

    public static void main(String[] args) {

        System.out.println("Guess number is:" + guessNumber(90));
    }

    public static long guessNumber(int n) {
        long start = 1, end = n;
        while (start <= end) {
            //to prevent from integer overflow
            long mid = start + (end - start) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) {
                start = mid + 1;
            } else end = mid - 1;
        }

        return -1;
    }

    private static long guess(long mid) {
        if (mid == pick) return 0;
        if (mid > pick) return -1;
        else return 1;
    }
}
