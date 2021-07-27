package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BottomView {

    static void bottomView(TreeNode root, int level, Map<Integer, TreeNode> levelMap) {

        if (null == root) {
            return;
        }

        levelMap.put(level, root);
        bottomView(root.left(), level - 1, levelMap);
        bottomView(root.right(), level + 1, levelMap);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        Map<Integer, TreeNode> levelMap = new HashMap<>();
        bottomView(root, 0, levelMap);
        System.out.println(levelMap);
    }
}
