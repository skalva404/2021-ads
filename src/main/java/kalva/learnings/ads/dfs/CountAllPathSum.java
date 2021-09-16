package kalva.learnings.ads.dfs;

import kalva.learnings.ads.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * <pre>
 *                       12
 *                    /     \
 *                  7         1
 *                /         /  \
 *              9         10    5
 *            /         /
 *          3         8
 * </pre>
 */
public class CountAllPathSum {

    static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {

        if (currentNode == null) {
            return 0;
        }
        currentPath.add(currentNode.data);

        int total = 0, pathSum = 0;
        ListIterator<Integer> iterator = currentPath.listIterator(currentPath.size());
        while (iterator.hasPrevious()) {
            pathSum += iterator.previous();
            if (S == pathSum) {
                total++;
            }
        }

        total += countPathsRecursive(currentNode.left, S, currentPath);
        total += countPathsRecursive(currentNode.right, S, currentPath);

        currentPath.remove(currentPath.size() - 1);
        return total;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        root.right.left.left = new TreeNode(8);
        System.out.println("Tree has path: " + countPaths(root, 31));
    }
}
