package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;

import static kalva.learnings.ads.TreeNode.*;

public class Distance {

    public static int distance(TreeNode root, int n1, int n2) {
        int p1 = distanceFromRoot(root, n1) - 1;
        int p2 = distanceFromRoot(root, n2) - 1;
        int lca = 2 * (distanceFromRoot(root, lca(root, n1, n2).data) - 1);
        return p1 + p2 - lca;
    }

    public static void kDistanceNodesFromLeaf(TreeNode root, int k, int height, int curLevel,
                                              ArrayList<TreeNode> nodes) {
        if (null == root) {
            return;
        }

        if (curLevel == height - k - 1) {
            nodes.add(root);
        }
        kDistanceNodesFromLeaf(root.left, k, height, curLevel + 1, nodes);
        kDistanceNodesFromLeaf(root.right, k, height, curLevel + 1, nodes);
    }

    public static void main(String[] args) {

        TreeNode root = TreeNode.createSampleTree();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        kDistanceNodesFromLeaf(root, 2, height(root), 0, nodes);
        System.out.println(nodes);
    }
}
