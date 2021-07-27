package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Heights {

    public static void verticleNodes(TreeNode root, int curLevel, Map<Integer, List<Integer>> lm) {
        if (null == root) {
            return;
        }
        lm.putIfAbsent(curLevel, new ArrayList<>());
        lm.get(curLevel).add(root.data);
        verticleNodes(root.left, curLevel - 1, lm);
        verticleNodes(root.right, curLevel + 1, lm);
    }

    public static void verticleSum(TreeNode root, int curLevel, Map<Integer, AtomicInteger> lm) {
        if (null == root) {
            return;
        }
        lm.putIfAbsent(curLevel, new AtomicInteger(0));
        lm.get(curLevel).getAndAdd(root.data);
        verticleSum(root.left, curLevel - 1, lm);
        verticleSum(root.right, curLevel + 1, lm);
    }

    public static int verticleHeight(TreeNode root, int curLevel, Map<Integer, AtomicInteger> lm) {
        verticle(root, curLevel, lm);
        return lm.values().stream().mapToInt(AtomicInteger::get).max().getAsInt();
    }

    private static void verticle(TreeNode root, int curLevel, Map<Integer, AtomicInteger> lm) {
        if (null == root) {
            return;
        }
        lm.putIfAbsent(curLevel, new AtomicInteger(0));
        lm.get(curLevel).getAndIncrement();

        verticle(root.left, curLevel - 1, lm);
        verticle(root.right, curLevel + 1, lm);
    }

    /**
     * <pre>
     *                  1
     *               /   \
     *              /     \
     *             2       3
     *                   /   \
     *                  /     \
     *                 5       6
     *               /   \
     *              /     \
     *             7       8
     * </pre>
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        Map<Integer, AtomicInteger> lm = new HashMap<>();
        System.out.println(verticleHeight(root, 0, lm));

        lm = new HashMap<>();
        verticleSum(root, 0, lm);
        System.out.println(lm);
    }
}
