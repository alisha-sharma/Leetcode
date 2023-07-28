package stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class DecodeString {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        if(s.length() < 3) return s;

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ']') stack.push(ch);
            else{
                String tempStr = "";
                while(Character.isLetter(stack.peek())){
                    tempStr = stack.pop() + tempStr;
                }
                stack.pop();
                String count = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    count = stack.pop() + count;
                }

                for(int i = 0; i < Integer.parseInt(count); i++){
                    for(char c : tempStr.toCharArray()){
                        stack.push(c);
                    }
                }

            }
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
