package memoization;

public class recursionWithMemoization {
    public static void main(String[] args) {
        int n = 5;
        // initializing each item with 0
        int[] memo = new int[n + 1];

        for(int i = 0; i < n; i++) {
            System.out.println(printFibo(i, memo));
        }
    }

    private static int printFibo(int n, int[] memo) {
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        else if(memo[n] > 0 ) return memo[n];
        memo[n] = printFibo(n-1, memo) + printFibo(n - 2, memo);
        return memo[n];
    }
}
