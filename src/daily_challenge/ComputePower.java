package daily_challenge;

public class ComputePower {

    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        System.out.println("Result is: " + myPow(x, n));
        System.out.println("Result is: " + myPowUsingBitManipulation(x, n));
    }


    //Time Complexity O(n), space complexity O(1)
    public static double myPowUsingBitManipulation(double x, int n) {
        if (x == 0) return 0;
        if (n == 0 || x == 1) return 1;

        double ans = 1;
        while (n > 0) {
            if (((n & 1) == 1)) {
                ans = ans * x;
            }
            x = x * x;
            n = n >> 1;
        }

        return ans;
    }

    // Time complexity O(logn), space complexity O(logn) due to recursive calls
    public static double myPow(double x, int num) {
        if (x == 0) return 0;
        if (num == 0 || x == 1) return 1;

        long n = (long) num;
        /*type casting to long,the value `-2147483648` after
        will cause overflow because int can store max `-2147483647`*/
        double result = powHelper(x, Math.abs(n));

        if (num < 0) return 1 / result;

        return result;
    }

    private static double powHelper(double x, long n) {
        if (n == 0) return 1;
        double tempResult = powHelper(x, n / 2);
        tempResult *= tempResult;
        if (n % 2 == 0) return tempResult;
        else return tempResult * x;
    }
}
