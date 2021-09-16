package kalva.learnings.ads.bfs;

import kalva.learnings.ads.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeDepth {

    public static int findMinDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minimumTreeDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minimumTreeDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (null == poll.left && null == poll.right) {
                    return minimumTreeDepth;
                }
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
        }
        return -1;
    }

    public static int findMaxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minimumTreeDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minimumTreeDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
        }
        return minimumTreeDepth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        System.out.println("Tree Minimum Depth: " + BinaryTreeDepth.findMinDepth(root));
        System.out.println("Tree Maximum Depth: " + BinaryTreeDepth.findMaxDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + BinaryTreeDepth.findMinDepth(root));
        System.out.println("Tree Maximum Depth: " + BinaryTreeDepth.findMaxDepth(root));
    }
}
