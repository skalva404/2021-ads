package kalva.learnings.ads.dfs;

import kalva.learnings.ads.TreeNode;

public class PathWithGivenSequence {

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
    static boolean findPath(TreeNode root, int currentIndex, int[] sequence) {

        if (null == root) {
            return false;
        }

        if (!(root.data == sequence[currentIndex])) {
            return false;
        }

        if (currentIndex == sequence.length - 1 && null == root.left && null == root.right) {
            return true;
        }

        return findPath(root.left, currentIndex + 1, sequence) ||
                findPath(root.right, currentIndex + 1, sequence);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.driverData();
        System.out.println(findPath(root, 0, new int[]{12, 1, 5}));
        System.out.println(findPath(root, 0, new int[]{12, 1, 15}));
        System.out.println(findPath(root, 0, new int[]{12, 7, 9, 3}));
    }
}
