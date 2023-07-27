package daily_challenge;

public class MinimumSpeedToArriveOnTime {
    public static void main(String[] args) {
        int[] dist = {1, 1, 100000};
        double hour = 2.1;
        System.out.println("Result: " + minSpeedOnTimeUsingBinarySearch(dist, hour));
    }

    //Time Complexity O(log(n) * n) and Space Complexity O(1)
    public static int minSpeedOnTimeUsingBinarySearch(int[] dist, double hour) {
        int start = 1;
        int end = (int) 1e7;
        int mindSpeed = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canReachOnTime(dist, mid, hour)) {
                mindSpeed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return mindSpeed;

    }

    public static boolean canReachOnTime(int[] dist, int mid, double hour) {
        double totalHours = 0;
        int len = dist.length;
        for (int i = 0; i < len - 1; i++) {
            double time = dist[i] * 1d / mid;
            totalHours += Math.ceil(time);
            if (totalHours > hour) return false;
        }
        totalHours += dist[len - 1] * 1d / mid;

        return totalHours <= hour;

    }
}
