package kalva.learnings.ads.companies.thoughtspot;

import kalva.learnings.ads.TreeNode;

import java.util.TreeMap;

//https://afteracademy.com/blog/merge-two-binary-trees
public class MergeBinaryTrees {

    public static TreeNode mergedBinaryTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }
        root1.data = root1.data + root2.data;
        root1.left = mergedBinaryTree(root1.left, root2.left);
        root1.right = mergedBinaryTree(root1.right, root2.right);

        return root1;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        root1 = mergedBinaryTree(root1, root2);
        TreeNode.preOrder(root1);
    }
}
