package binary_tree;


import java.util.ArrayList;
import java.util.Arrays;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root1 = initializeFirstTree();
        TreeNode root2 = initializeSecondTree();

        System.out.println("Has same leaf node sequence: " + hasSameLeafNodeSequence(root1, root2));
    }

    private static boolean hasSameLeafNodeSequence(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();

        performDFS(root1, leaf1);
        performDFS(root2, leaf2);

        if (leaf1.size() != leaf2.size()) return false;

        return leaf1.equals(leaf2);
    }

    private static void performDFS(TreeNode root, ArrayList<Integer> leaf) {
        if (root == null) return;
        if (root.left == null && root.right == null) leaf.add(root.val);

        performDFS(root.left, leaf);
        performDFS(root.right, leaf);
    }

    private static TreeNode initializeSecondTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(8);

        return root;
    }

    private static TreeNode initializeFirstTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

        return root;
    }
}

