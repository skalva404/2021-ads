package kalva.learnings.ads.companies.thoughtspot;

import kalva.learnings.ads.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class SerDeTree {

    private static int index = 0;

    public static void main(String[] args) {
        int myArr[] = {
                5,
                9,
                2,
                8,
                -1,
                -1,
                -1,
                4,
                -1,
                7,
                -1,
                -1,
                1,
                -1,
                3,
                -1,
                -1
        };

        Arrays.stream(myArr).forEach(value -> {
            System.out.print(value + "\t");
        });
        System.out.println();

        TreeNode root = arrayToTree(myArr);
        TreeNode.preOrder(root);

        index = 0;
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        treeToArray(list, root);
        list.forEach(value -> {
            System.out.print(value + "\t");
        });
    }

    private static void treeToArray(ArrayList<Integer> list, TreeNode root) {

        if (null == root) {
            list.add(-1);
            return;
        }
        list.add(root.data);
        treeToArray(list, root.left);
        treeToArray(list, root.right);
    }

    private static TreeNode arrayToTree(int[] myArr) {

        if (index > myArr.length) {
            return null;
        }
        if (-1 == myArr[index]) {
            return null;
        }

        TreeNode node = new TreeNode(myArr[index]);

        index++;
        node.left = arrayToTree(myArr);

        index++;
        node.right = arrayToTree(myArr);
        return node;
    }
}
