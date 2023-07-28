package daily_challenge;

public class PredictWinner {
    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println("Player one wins: " + PredictTheWinnerApproach1(nums));
        System.out.println("Player one wins: " + PredictTheWinnerApproach2(nums));
    }

    private static boolean PredictTheWinnerApproach2(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        return getScore(0, nums.length - 1, nums, memo) >= 0;
    }


    /* i,  j => P1 options
     /        \
 i+1, j          i, j-1 => p2 options
  /   \          /      \
i+2, j   i+1,j-1  i+1,j-1  i, j-2 p1 options
                 */
    private static int getScore(int i, int j, int[] nums, int[][] memo) {
        if (i == j) return nums[i];

        if (memo[i][j] != 0) return memo[i][j];

        int iScore = nums[i] - getScore(i + 1, j, nums, memo);
        int jScore = nums[j] - getScore(i, j - 1, nums, memo);

        return memo[i][j] = Math.max(iScore, jScore);
    }

    public static boolean PredictTheWinnerApproach1(int[] nums) {
        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }

        int[][] memo = new int[nums.length][nums.length];
        int player1_score = solve(0, nums.length - 1, nums, memo);
        int player2_score = totalScore - player1_score;

        return player1_score >= player2_score;

    }

    private static int solve(int i, int j, int[] nums, int[][] memo) {
        if (i > j) return 0;
        // if only one element is left, return the element
        if (i == j) return nums[i];

        if (memo[i][j] != 0) return memo[i][j];

        // when player chooses i
        int choose_i = nums[i] + Math.min(solve(i + 2, j, nums, memo), solve(i + 1, j - 1, nums, memo));
        // when player chooses j
        int choose_j = nums[j] + Math.min(solve(i + 1, j - 1, nums, memo), solve(i, j - 2, nums, memo));

        return memo[i][j] = Math.max(choose_i, choose_j);
    }
}
