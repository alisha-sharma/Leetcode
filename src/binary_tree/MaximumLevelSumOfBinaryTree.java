package binary_tree;

import java.util.*;

public class MaximumLevelSumOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println("------Using BFS-----");
        System.out.println("Result: " + maxLevelSumUsingBFS(root));
        System.out.println("------Using DFS-----");
        System.out.println("Result: " + maxLevelSumUsingDFS(root));
    }

    /* Time Complexity O(N), where N is total number of nodes
         Space Complexity O(H), where H is the max height of the tree*/
    private static int maxLevelSumUsingDFS(TreeNode root) {
        if (root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        maxLevelSumHelper(root, 1, map);

        int maxLevel = 1;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxLevel = entry.getKey();
            }
        }

        return maxLevel;
    }

    private static void maxLevelSumHelper(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root == null) return;
        map.put(level, map.getOrDefault(level, 0) + root.val);
        level++;
        maxLevelSumHelper(root.left, level, map);
        maxLevelSumHelper(root.right, level, map);
    }

    /* Time Complexity O(N), where N is total number of nodes
        Space Complexity O(W), where W is the max width  of the tree*/
    public static int maxLevelSumUsingBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1, maxLevel = 1;
        int maxValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (levelSum > maxValue) {
                maxValue = levelSum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;
    }
}
