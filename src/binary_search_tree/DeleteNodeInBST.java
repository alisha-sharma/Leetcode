package binary_search_tree;

import binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

import static binary_search_tree.Utils.*;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        System.out.println("Node values after deletion in first tree: "
                + getNodeValues(deleteNode(initializeFirstTree(), 3)));
        System.out.println("Node values after deletion in second tree: "
                + getNodeValues(deleteNode(initializeSecondTree(), 50)));
    }

    private static TreeNode initializeSecondTree() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        return root;
    }

    private static TreeNode initializeFirstTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                TreeNode current = root.right;
                while (current.left != null) {
                    current = current.left;
                }
                root.val = current.val;

                root.right = deleteNode(root.right, root.val);

            }
        }

        return root;

    }
}
