package kalva.learnings.ads.avl;

import kalva.learnings.ads.TreeNode;

public class ConstructAVLTree {

    private static int getHeight(TreeNode TreeNode) {
        return TreeNode == null ? -1 : TreeNode.height;
    }

    private static int getMaxHeight(int leftTreeNodeHeight, int rightTreeNodeHeight) {
        return leftTreeNodeHeight > rightTreeNodeHeight ? leftTreeNodeHeight : rightTreeNodeHeight;
    }

    private static TreeNode insert(int value, TreeNode root) {
        return AVLTree.insert(value, root);
    }

    private static TreeNode rotateWithleft(TreeNode TreeNode2) {
        TreeNode TreeNode1 = TreeNode2.left;
        TreeNode2.left = TreeNode1.right;
        TreeNode1.right = TreeNode2;
        TreeNode2.height = getMaxHeight(getHeight(TreeNode2.left), getHeight(TreeNode2.right)) + 1;
        TreeNode1.height = getMaxHeight(getHeight(TreeNode1.left), TreeNode2.height) + 1;
        return TreeNode1;
    }

    private static TreeNode rotateWithright(TreeNode TreeNode1) {
        TreeNode TreeNode2 = TreeNode1.right;
        TreeNode1.right = TreeNode2.left;
        TreeNode2.left = TreeNode1;
        TreeNode1.height = getMaxHeight(getHeight(TreeNode1.left), getHeight(TreeNode1.right)) + 1;
        TreeNode2.height = getMaxHeight(getHeight(TreeNode2.right), TreeNode1.height) + 1;
        return TreeNode2;
    }

    private static TreeNode doubleWithleft(TreeNode TreeNode3) {
        TreeNode3.left = rotateWithright(TreeNode3.left);
        return rotateWithleft(TreeNode3);
    }

    private static TreeNode doubleWithright(TreeNode TreeNode1) {
        TreeNode1.right = rotateWithleft(TreeNode1.right);
        return rotateWithright(TreeNode1);
    }

    private static void inorderTraversal(TreeNode head) {
        if (head != null) {
            inorderTraversal(head.left);
            System.out.print(head.data + "[" + head.height + "] ");
            inorderTraversal(head.right);
        }
    }

    public static void main(String[] args) {

        TreeNode insert = insert(50, null);
        insert = insert(50, insert);
        insert = insert(30, insert);
        insert = insert(40, insert);
        insert = insert(20, insert);
        insert = insert(70, insert);
        insert = insert(60, insert);
        insert = insert(80, insert);

        inorderTraversal(insert);
    }
}
