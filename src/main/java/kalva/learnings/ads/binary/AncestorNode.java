package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AncestorNode {

    private static boolean isAncestor(TreeNode node, int data, List<Integer> parents) {
        if (null == node) {
            return false;
        }
        if (data == node.data()) {
            return true;
        }
        boolean left = isAncestor(node.left(), data, parents);
        if (left) {
            parents.add(node.data());
            return true;
        }
        boolean right = isAncestor(node.right(), data, parents);
        if (right) {
            parents.add(node.data());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        List<Integer> a1 = new ArrayList<>();
        isAncestor(TreeNode.createSampleTree(), 9, a1);
        System.out.println(a1);
    }
}
