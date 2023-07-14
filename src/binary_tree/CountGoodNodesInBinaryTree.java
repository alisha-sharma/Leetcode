package binary_tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = initializeFirstTree();
        TreeNode root2 = initializeSecondTree();

        System.out.println("Number of good nodes in first tree: " + goodNodes(root1));
        System.out.println("Number of good nodes in first tree: " + goodNodes(root2));
    }

    private static int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        return 1 + checkGoodNodes(root, root.val);
    }

    private static int checkGoodNodes(TreeNode root, int val) {
        int total = 0;
        if (root.left != null) {
            if (root.left.val >= val) {
                total += 1 + checkGoodNodes(root.left, root.left.val);
            } else {
                total += checkGoodNodes(root.left, val);
            }
        }

        if (root.right != null) {
            if (root.right.val >= val) {
                total += 1 + checkGoodNodes(root.right, root.right.val);
            } else total += checkGoodNodes(root.right, val);
        }

        return total;
    }

    private static TreeNode initializeFirstTree() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        return root;

    }

    private static TreeNode initializeSecondTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        return root;
    }


}
