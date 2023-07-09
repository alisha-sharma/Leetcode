package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

           /* 3
           /  \
          9    20
               /  \
              15   7*/

        System.out.println("The maximum depth of the tree using recursive DFS: " + maxDepthUsingRecursiveDFS(root));
        System.out.println("The maximum depth of the tree using BFS: " + maxDepthUsingBFS(root));
        System.out.println("The maximum depth of the tree using iterative DFS: " + maxDepthUsingIterativeDFS(root));
    }

    private static int maxDepthUsingIterativeDFS(TreeNode root) {
        if (root == null) return 0;
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root, 1});
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            Object[] pair = stack.pop();
            TreeNode node = (TreeNode) pair[0];
            int depth = (int) pair[1];

            if (node.left != null) stack.push(new Object[]{node.left, depth + 1});
            if (node.right != null) stack.push(new Object[]{node.right, depth + 1});

            if (depth > maxDepth) maxDepth = depth;
        }
        return maxDepth;
    }

    private static int maxDepthUsingBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return level;
    }

    private static int maxDepthUsingRecursiveDFS(TreeNode root) {
        if (root == null) return 0;
        ;
        return Math.max(maxDepthUsingRecursiveDFS(root.left), maxDepthUsingRecursiveDFS(root.right)) + 1;
    }


}