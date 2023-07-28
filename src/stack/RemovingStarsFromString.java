package stack;

public class RemovingStarsFromString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println("Result is: " + removeStarsWithStack(s));
    }

    public static String removeStarsWithStack(String s) {

        if(s.length() == 1) return s;

        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != '*') sb.append(ch);
            else sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
