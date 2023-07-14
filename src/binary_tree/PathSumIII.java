package binary_tree;

import java.util.HashMap;

public class PathSumIII {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

                   /* 10
                   /  \
                  5    -3
                /   \    \
               3     2     11
              / \      \
             3   -2      1    */
        pathSum(root, 8);
        System.out.println("The path sum result is : " + count);
        count = 0;
        pathSumOptimized(root, 8);
        System.out.println("The path sum result after optimization: " + count);
    }

    private static void pathSumHelper(TreeNode root, int sum, int target) {
        if (root != null) {
            sum += root.val;
            if (sum == target) count++;

            pathSumHelper(root.left, sum, target);
            pathSumHelper(root.right, sum, target);
        }
    }

    /*Time complexity O(n^2) */
    private static void pathSum(TreeNode root, int target) {
        if (root == null) return;

        pathSumHelper(root, 0, target);
        pathSum(root.left, target);
        pathSum(root.right, target);
    }

    /*Time complexity O(n) */
    private static int pathSumOptimized(TreeNode root, int target) {
        if (root == null) return 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        pathSumHelperOptimized(root, 0, (long) target, map);
        return count;
    }

    private static void pathSumHelperOptimized(TreeNode root, long sum, long target, HashMap<Long, Integer> map) {
        if (root != null) {
            sum += root.val;
            long key = sum - target;
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            pathSumHelperOptimized(root.left, sum, target, map);

            pathSumHelperOptimized(root.right, sum, target, map);
            //backtrack
            map.put(sum, map.get(sum) - 1);
            return;
        }
    }
}

