package kalva.learnings.ads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Accessors(fluent = true)
public class TreeNode {

    public Integer data;
    public TreeNode left;
    public TreeNode next;
    public TreeNode right;
    public Integer height;

    public TreeNode(Integer data) {
        this.data = data;
    }

    /**
     * <pre>
     *                     1
     *                   /   \
     *                 2      3
     *               /  \       \
     *             4     5       6
     *           /   \         /   \
     *         7      8      9     10
     *              /  \
     *            11    13
     *           /       \
     *         12        14
     *                    \
     *                    15
     * </pre>
     */
    public static TreeNode createSampleTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);

        root.left.left.right.right = new TreeNode(13);
        root.left.left.right.right.right = new TreeNode(14);
        root.left.left.right.right.right.right = new TreeNode(15);
        root.left.left.right.left = new TreeNode(11);
        root.left.left.right.left.left = new TreeNode(12);

        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        return root;
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
    public static TreeNode driverData() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        return root;
    }

    public static void inOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        inOrder(node.left());
        System.out.print(node.data() + "\t");
        inOrder(node.right());
    }

    public static void preOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(node.data() + "\t");
        preOrder(node.left());
        preOrder(node.right());
    }

    public static void postOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        preOrder(node.left());
        preOrder(node.right());
        System.out.print(node.data() + "\t");
    }

    public static TreeNode leftMostNode(TreeNode searchNode) {
        TreeNode temp = searchNode;
        while (null != temp && null != temp.left()) {
            temp = temp.left();
        }
        return temp;
    }

    public static TreeNode rightMostNode(TreeNode searchNode) {
        TreeNode temp = searchNode.right();
        while (null != temp && null != temp.right()) {
            temp = temp.right();
        }
        return temp;
    }

    public static List<TreeNode> findOuterPaths(TreeNode root, int target, boolean isLeft) {
        if (null == root) {
            return null;
        }
        if (Objects.equals(root.data, target)) {
            return new ArrayList<>();
        }
        List<TreeNode> parents;
        if (isLeft) {
            parents = findOuterPaths(root.left(), target, isLeft);
            if (null != parents) {
                parents.add(0, root);
                return parents;
            }
        }
        if (!isLeft) {
            parents = findOuterPaths(root.right(), target, isLeft);
            if (null != parents) {
                parents.add(0, root);
                return parents;
            }
        }
        return null;
    }

    public static int diameter(TreeNode root) {
        List<TreeNode> leftOouterPaths = findOuterPaths(root, leftMostNode(root).data, true);
        List<TreeNode> rightOouterPaths = findOuterPaths(root, rightMostNode(root).data, false);
        return leftOouterPaths.size() + rightOouterPaths.size() + 1;
    }

    public static TreeNode lca(TreeNode root, int n1, int n2) {
        if (null == root) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);
        if (null != left && null != right) {
            return root;
        }
        return null != left ? left : right;
    }

    public static int distanceFromRoot(TreeNode node, int data) {
        if (null == node) {
            return 0;
        }
        if (data == node.data) {
            return 1;
        }
        int left = distanceFromRoot(node.left, data);
        int right = distanceFromRoot(node.right, data);
        if (0 < left) {
            return 1 + left;
        }
        if (0 < right) {
            return 1 + right;
        }
        return 0;
    }

    public static int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static TreeNode value(int data) {
        return new TreeNode(data);
    }

    public void printBFS() {
        for (int i = 1; i <= height(this); i++) {
            _printBFS(this, i, 1);
        }
    }

    private void _printBFS(TreeNode node, int level, int currentLevel) {
        if (null == node) {
            return;
        }
        if (level == currentLevel && null != node.data) {
            System.out.print(node + "  ");
            return;
        }
        _printBFS(node.left(), level, currentLevel + 1);
        _printBFS(node.right(), level, currentLevel + 1);
    }

    private void _printInOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        _printInOrder(node.left());
        System.out.print(node.data() + "\t");
        _printInOrder(node.right());
    }

    public static void printFullNode(TreeNode root) {
        if (null == root) {
            return;
        }
        if (null != root.left() && null != root.right()) {
            System.out.print(root.data + "\t");
        }
        printFullNode(root.left());
        printFullNode(root.right());
    }

    public void printTree() {
        TreeNode current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.data + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        System.out.println(findOuterPaths(createSampleTree(), 7, true));
//        System.out.println(findOuterPaths(createSampleTree(), 10, false));
//        System.out.println(diameter(createSampleTree()));
        TreeNode sampleTree = createSampleTree();
//        System.out.println(lca(sampleTree, 4, 6));
//        System.out.println(distanceFromRoot(sampleTree, 12));
//        System.out.println(distanceFromRoot(sampleTree, 10));
//        System.out.println(distance(sampleTree, 12, 10));
        System.out.println(height(sampleTree));
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
