package kalva.learnings.ads.dfs;

import kalva.learnings.ads.TreeNode;

/**
 * <pre>
 *                       1
 *                    /     \
 *                  7         1
 *                /         /  \
 *              9         1    5
 *            /
 *          3
 * </pre>
 * <p>
 * 1793 + 111 + 115
 */
public class SumOfPathNumbers {

    public static int findSumOfPathNumbers(TreeNode root) {
        // TODO: Write your code here
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (null == currentNode) {
            return 0;
        }
        pathSum = pathSum * 10 + currentNode.data;
        if (null == currentNode.left && null == currentNode.right) {
            return pathSum;
        }


        int left = findRootToLeafPathNumbers(currentNode.left, pathSum);
        int right = findRootToLeafPathNumbers(currentNode.right, pathSum);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        root.data = 1;
        root.right.left.data = 1;
        System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
    }
}
