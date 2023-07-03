package basics;

public class PrintAllFibonacciSeries {
    public static void main(String[] args) {
        int num = 10;
        printSeries(num);
    }

    private static void printSeries(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(findFibonacciSeries(i));
        }
    }

    private static int findFibonacciSeries(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return findFibonacciSeries(i - 1) + findFibonacciSeries(i - 2);
    }
}
