package binary_search_tree;

import binary_tree.TreeNode;
import java.util.*;

public class Utils {
    public static List<Integer> getNodeValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    result.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
