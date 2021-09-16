package kalva.learnings.ads.bfs;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean direction = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            result.add(level);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (direction) {
                    level.add(poll.data);
                } else {
                    level.add(0, poll.data);
                }
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
            direction = !direction;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
