package kalva.learnings.ads.bfs;

import kalva.learnings.ads.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static kalva.learnings.ads.bfs.ConnectAllSiblings.connectNodes;

public class ConnectLevelOrderSiblings {

    private static void connect(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            connectNodes(queue, null);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
