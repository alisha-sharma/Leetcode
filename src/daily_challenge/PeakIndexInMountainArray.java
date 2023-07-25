package daily_challenge;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println("Peak Index is: " + peakIndexInMountainArray(arr));
    }


    public static int peakIndexInMountainArray(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (arr[mid] > arr[mid + 1]) {
                endIndex = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                startIndex = mid + 1;
            }
        }

        return startIndex;
    }
}
