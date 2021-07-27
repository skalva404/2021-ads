package kalva.learnings.ads.binary;


import kalva.learnings.ads.TreeNode;

/**
 * * https://algorithms.tutorialhorizon.com/find-whether-if-a-given-binary-tree-is-balanced/
 * *                            5
 * *                      10         15
 * *                   20   25    30    35
 * *                                       40
 * *                                          45
 **/
public class BalancedTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left(new TreeNode(10));
        root.right(new TreeNode(15));
        root.left().left(new TreeNode(20));
        root.left().right(new TreeNode(25));
        root.right().left(new TreeNode(30));
        root.right().right(new TreeNode(35));
        System.out.println(" Is Tree Balanced : " + (isBalanced(root) > 0));
        root.right().right().right(new TreeNode(40));
        root.right().right().right().right(new TreeNode(45));
        System.out.println(" Is Tree Balanced : " + (isBalanced(root) > 0));
    }

    private static int isBalanced(TreeNode root) {

        if (null == root) {
            return 0;
        }

        int left = isBalanced(root.left());
        int right = isBalanced(root.right());

        if (1 < Math.abs(left - right)) {
            return -1;
        }
        if (-1 == left || -1 == right) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
