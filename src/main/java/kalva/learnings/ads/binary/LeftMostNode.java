package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

public class LeftMostNode {

    static int leftmostLevel;
    static TreeNode leftmostNode;

    static int deepestLevel;
    static TreeNode deepestNode;

    static void leftMostNode(TreeNode root, int level, boolean leftNode) {

        if (null == root) {
            return;
        }
        if (leftNode && level > leftmostLevel) {
            leftmostLevel = level;
            leftmostNode = root;
        }
        leftMostNode(root.left, level + 1, true);
        leftMostNode(root.right, level + 1, false);
    }

    static void deepestNode(TreeNode root, int level) {
        if (null == root) {
            return;
        }
        if (level > deepestLevel) {
            deepestLevel = level;
            deepestNode = root;
        }
        deepestNode(root.left, level + 1);
        deepestNode(root.right, level + 1);
    }

    public static void main(String[] args) {

        deepestNode(TreeNode.createSampleTree(), 0);
        System.out.println(deepestNode);

        leftMostNode(TreeNode.createSampleTree(), 0, false);
        System.out.println(leftmostNode);
    }
}
