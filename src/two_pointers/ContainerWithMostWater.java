package two_pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + maxArea(height));
    }

    public static int maxArea(int[] height) {
        int startIndex = 0;
        int endIndex = height.length - 1;
        int maxArea = 0;
        while (startIndex < endIndex) {
            int firstElement = height[startIndex];
            int secondElement = height[endIndex];
            int area;
            if (firstElement < secondElement) {
                area = firstElement * (endIndex - startIndex);
                if (area > maxArea) maxArea = area;
                startIndex++;
            } else if (firstElement >= secondElement) {
                area = secondElement * (endIndex - startIndex);
                if (area > maxArea) maxArea = area;
                endIndex--;
            }
        }
        return maxArea;
    }
}
