package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

public class RecurssionOps {

    private static void inOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        inOrder(node.left());
        System.out.print(node.data() + "\t");
        inOrder(node.right());
    }

    private static void preOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(node.data() + "\t");
        preOrder(node.left());
        preOrder(node.right());
    }

    private static void postOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        preOrder(node.left());
        preOrder(node.right());
        System.out.print(node.data() + "\t");
    }

    public static void main(String[] args) {

        inOrder(TreeNode.createSampleTree());
        System.out.println();
        preOrder(TreeNode.createSampleTree());
        System.out.println();
        postOrder(TreeNode.createSampleTree());
    }
}
