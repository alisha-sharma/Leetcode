package basics;

public class printNthFibonacciSeries {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(printNthFibonacciNumber(7));
    }

    private static int printNthFibonacciNumber(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return printNthFibonacciNumber(n - 1) + printNthFibonacciNumber(n - 2);
    }
}
