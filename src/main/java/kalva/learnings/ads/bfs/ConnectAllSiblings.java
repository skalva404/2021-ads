package kalva.learnings.ads.bfs;

import kalva.learnings.ads.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {

    private static void connect(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode prev = null;
        while (!queue.isEmpty()) {
            prev = connectNodes(queue, prev);
        }
    }

    static TreeNode connectNodes(Queue<TreeNode> queue, TreeNode prev) {
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
            TreeNode curr = queue.poll();
            if (null != prev) {
                prev.next = curr;
            }
            prev = curr;
            if (null != curr.left) {
                queue.offer(curr.left);
            }
            if (null != curr.right) {
                queue.offer(curr.right);
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printTree();
    }
}
