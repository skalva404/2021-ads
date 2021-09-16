package kalva.learnings.ads.bst;

import kalva.learnings.ads.TreeNode;

/**
 * <pre>
 *               50
 *            /     \
 *           30      70
 *          /  \    /  \
 *        20   40  60   80
 * </pre>
 */
public class BinarySearchTree {

    static TreeNode insert(TreeNode node, int key) {
        if (null == node) {
            return new TreeNode(key);
        }
        if (key < node.data()) {
            node.left(insert(node.left, key));
        } else if (key > node.data()) {
            node.right(insert(node.right, key));
        }
        return node;
    }

    static void inorder(TreeNode root) {
        if (null == root) {
            return;
        }
        inorder(root.left());
        System.out.print(root.data() + "  ");
        inorder(root.right());
    }

    public static void main(String[] args) {
        TreeNode insert = insert(null, 50);
        insert = insert(insert, 30);
        insert = insert(insert, 20);
        insert = insert(insert, 40);
        insert = insert(insert, 70);
        insert = insert(insert, 60);
        insert = insert(insert, 80);
        inorder(insert);
    }
}
