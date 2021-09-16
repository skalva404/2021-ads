package kalva.learnings.ads.dfs;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {

    public static boolean hasPath(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (sum == root.data && null == root.left && null == root.right) {
            return true;
        }

        return hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data);
    }

    public static List<List<Integer>> findPaths(TreeNode root, Integer sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        if (null == sum) {
            findPathsRecursive(root, currentPath, allPaths);
        } else {
            findPathsRecursive(root, sum, currentPath, allPaths);
        }
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currNode, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (null == currNode) {
            return;
        }

        currentPath.add(currNode.data);
        if (null == currNode.left && null == currNode.right) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findPathsRecursive(currNode.left, currentPath, allPaths);
            findPathsRecursive(currNode.right, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    /**
     * <pre>
     *                       12
     *                    /     \
     *                  7         1
     *                /         /  \
     *              9         10    5
     *            /
     *          3
     * </pre>
     */
    private static void findPathsRecursive(TreeNode currNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (null == currNode) {
            return;
        }

        currentPath.add(currNode.data);
        if (sum == currNode.data && null == currNode.left && null == currNode.right) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findPathsRecursive(currNode.left, sum - currNode.data, currentPath, allPaths);
            findPathsRecursive(currNode.right, sum - currNode.data, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));

        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
        result = findPaths(root, null);
        System.out.println("Tree paths to leaf" + ": " + result);
    }
}
