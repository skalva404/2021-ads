package kalva.learnings.ads.dfs;

import kalva.learnings.ads.TreeNode;

public class MaximumPathSum {

    private static int globalMaximumSum = Integer.MIN_VALUE;

    private static int findMaximumPathSumRecursive(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int leftSum = Math.max(findMaximumPathSumRecursive(currentNode.left), 0);
        int rightSum = Math.max(findMaximumPathSumRecursive(currentNode.right), 0);

        int localMaximumSum = leftSum + rightSum + currentNode.data;
        globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

        return Math.max(leftSum, rightSum) + currentNode.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        findMaximumPathSumRecursive(root);
        System.out.println("Maximum Path Sum: " + globalMaximumSum);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        System.out.println("Maximum Path Sum: " + globalMaximumSum);

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        System.out.println("Maximum Path Sum: " + globalMaximumSum);
    }
}
