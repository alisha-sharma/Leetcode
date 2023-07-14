package binary_tree;

public class LongestZigZagPath {
    static int maxCount = 0;
    public static void main(String[] args) {
        System.out.println("Longest ZigZag path is: " + longestZigZag(InitializeFirstTree()));
        System.out.println("Longest ZigZag path is: " + longestZigZag(InitializeSecondTree()));
    }

    private static TreeNode InitializeSecondTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);

                  /* 1
                   /  \
                  1    1
                   \
                     1
                     /  \
                    1    1
                     \
                       1
                         */

        return root;
    }

    private static TreeNode InitializeFirstTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);

                   /* 1
                      \
                       1
                     /    \
                     1     1
                          /  \
                         1    1
                         \
                          1
                           \
                            1 */

       return root;
    }

    public static int longestZigZag(TreeNode root) {
        if(root == null) return 0;

        int count = Math.max(longestZigZagHelperLeft(root), longestZigZagHelperRight(root));
        if(count > maxCount)
            maxCount = count;

        longestZigZag(root.right);
        longestZigZag(root.left);

        return maxCount;
    }

    private static int longestZigZagHelperRight(TreeNode root){
        if(root == null) return 0;
        int count = 0;
        if(root.right != null){
            count += 1 + longestZigZagHelperLeft(root.right);
        }

        return count;
    }

    private static int longestZigZagHelperLeft(TreeNode root){
        if(root == null) return 0;
        int count = 0;

        if(root.left != null){
            count += 1 + longestZigZagHelperRight(root.left);
        }

        return count;
    }
}
