package binary_search_tree;

import binary_tree.TreeNode;
import static binary_search_tree.Utils.*;

public class SearchInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Subtree rooted with the searched node: " + getNodeValues(searchBST(root, 2)));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
