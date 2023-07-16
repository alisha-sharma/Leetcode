package binary_tree;

import java.util.*;

public class RightSideViewOfBinaryTree {
    public static void main(String[] args) {
        System.out.println("------Using BFS------");
        System.out.println("Result from first tree: " + rightSideViewUsingQueue(initializeFirstTree()));
        System.out.println("Result from second tree: " + rightSideViewUsingQueue(initializeSecondTree()));
        System.out.println("------Using DFS------");
        System.out.println("Result from first tree: " + rightSideViewUsingQueue(initializeFirstTree()));
        System.out.println("Result from second tree: " + rightSideViewUsingQueue(initializeSecondTree()));
    }

    private static TreeNode initializeSecondTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        return root;
    }

    private static TreeNode initializeFirstTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findView(root, result, 0);
        return result;
    }

    private void findView(TreeNode root, List<Integer> result, int level){
        if(root == null) return;

        // we just need to add only one node in each level
        if(result.size() == level) result.add(root.val);

        findView(root.right, result, level + 1);
        findView(root.left, result, level + 1);

    }

    public static List<Integer> rightSideViewUsingQueue(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    if(i == 0) list.add(node.val);
                    if(node.right != null) queue.add(node.right);
                    if(node.left != null) queue.add(node.left);
                }
            }

        }

        return list;

    }
}
