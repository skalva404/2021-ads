package kalva.learnings.ads.avl;

import kalva.learnings.ads.TreeNode;

public class AVLTree {

    private static int getHeight(TreeNode node) {
        return node == null ? -1 : node.height;
    }

    private static int getMaxHeight(int leftHeight, int rightHeight) {
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    private static TreeNode rotateWithleft(TreeNode node) {
        TreeNode temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.height = getMaxHeight(getHeight(node.right), getHeight(node.left)) + 1;
        temp.height = getMaxHeight(getHeight(temp.right), getHeight(temp.left)) + 1;
        return temp;
    }

    private static TreeNode doubleWithleft(TreeNode node) {
        node.left = rotateWithright(node.left);
        return rotateWithleft(node);
    }

    private static TreeNode rotateWithright(TreeNode node) {
        TreeNode temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.height = getMaxHeight(getHeight(node.right), getHeight(node.left)) + 1;
        temp.height = getMaxHeight(getHeight(temp.right), getHeight(temp.left)) + 1;
        return temp;
    }

    private static TreeNode doubleWithright(TreeNode node) {
        node.right = rotateWithleft(node.right);
        return rotateWithright(node);
    }

    private static void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + "[" + root.height + "] ");
        preOrder(root.right);
    }

    static TreeNode insert(int value, TreeNode root) {
        if (null == root) {
            root = new TreeNode(value);
        }
        if (value < root.data) {
            root.left = insert(value, root.left);
            if (2 == getHeight(root.left) - getHeight(root.right)) {
                if (value < root.left.data) {
                    root = rotateWithleft(root);
                } else {
                    root = doubleWithleft(root);
                }
            }
        } else if (value > root.data) {
            root.right = insert(value, root.right);
            if (2 == getHeight(root.right) - getHeight(root.left)) {
                if (value > root.right.data) {
                    root = rotateWithright(root);
                } else {
                    root = doubleWithright(root);
                }
            }
        }
        root.height = getMaxHeight(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    /**
     * <pre>
     *                   80
     *               /        \
     *             40         120
     *            / \        /   \
     *          30  60     90    125
     *         /   / \      \
     *        20  50 70     100
     * </pre>
     */
    public static void main(String[] args) {

        TreeNode insert = insert(50, null);
        insert = insert(30, insert);
        insert = insert(40, insert);
        insert = insert(20, insert);
        insert = insert(70, insert);
        insert = insert(60, insert);
        insert = insert(80, insert);
        insert = insert(90, insert);
        insert = insert(125, insert);
        insert = insert(120, insert);
        insert = insert(100, insert);
        print(insert);
    }

    private static void print(TreeNode insert) {
        preOrder(insert);
        System.out.println();
    }
}
