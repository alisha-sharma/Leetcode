package stack;

import java.util.*;

public class AsteroidCollison {
    public static void main(String[] args) {
        int[] asteroids = {-2, 2, 1, -2};
        int[] result = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) stack.push(asteroids[i]);
            else {
                if (asteroids[i] > 0) {
                    stack.push(asteroids[i]);
                } else {
                    if (stack.peek() < 0) stack.push(asteroids[i]);
                    else {
                        int absVal = Math.abs(asteroids[i]);
                        while (!stack.isEmpty() && absVal >= stack.peek()) {
                            if (stack.peek() == absVal) {
                                stack.pop();
                                break;
                            }
                            if (stack.peek() < 0) {
                                stack.push(asteroids[i]);
                                break;
                            } else {
                                stack.pop();
                                if (stack.isEmpty()) {
                                    stack.push(asteroids[i]);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (stack.size() == 0) return new int[]{};
        int[] arr = new int[stack.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }

        return arr;


    }
}
