package basics;

public class computePower {
    public static void main(String[] args) {
        int a = 3, b = 2;
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        System.out.println("The result is: " + result);
    }
}
