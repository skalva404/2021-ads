package kalva.learnings.ads.binary;

import kalva.learnings.ads.TreeNode;

public class InorderDFStoTree {

    static int counter = 0;

    public static void main(String[] args) {
        TreeNode node = inorderDFStoTree(
                new int[]{1, 2, 4, 8, 5, 3, 6, 7, 9}, //dfs
                new int[]{8, 4, 2, 5, 1, 6, 3, 7, 9}, //io
                0, 8);
        assert node != null;
        node.printBFS();
    }

    private static TreeNode inorderDFStoTree(int[] dfs, int[] io, int s, int e) {
        if (s > e) {
            return null;
        }
        TreeNode node = TreeNode.value(dfs[counter++]);
        if (s == e) {
            return node;
        }
        int index = findIndex(io, node.data, s, e);
        node.left(inorderDFStoTree(dfs, io, s, index - 1));
        node.right(inorderDFStoTree(dfs, io, index + 1, e));
        return node;
    }

    private static int findIndex(int[] inOrder, int search, int s, int e) {
        for (int i = s; i <= e; i++) {
            int anInOrder = inOrder[i];
            if (search == anInOrder) {
                return i;
            }
        }
        return -1;
    }
}
