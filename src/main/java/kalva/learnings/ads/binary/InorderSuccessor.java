package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static kalva.learnings.ads.TreeNode.createSampleTree;

public class InorderSuccessor {

    private static TreeNode successor;
    private static Boolean found = false;
    private static List<TreeNode> leafSuccessors = new ArrayList<>();

    private static void inorderSuccessor(TreeNode root, Integer data) {
        if (null == root) {
            return;
        }
        if (data.equals(root.data())) {
            found = true;
            return;
        }
        inorderSuccessor(root.left, data);
        if (found) {
            found = false;
            successor = root;
            return;
        }
        inorderSuccessor(root.right, data);
    }

    public static void findInorderLeafNodesSuccessors(TreeNode root) {
        if (null == root) {
            return;
        }
        findInorderLeafNodesSuccessors(root.left);
        if (null == root.left && null == root.right) {
            found = true;
        } else if (found) {
            leafSuccessors.add(root);
            found = false;
        }
        findInorderLeafNodesSuccessors(root.right);
    }

    public static void main(String[] args) {
        inorderSuccessor(createSampleTree(), 5);
        System.out.println(successor);

        found = false;
        findInorderLeafNodesSuccessors(createSampleTree());
        System.out.println(leafSuccessors);
    }
}
