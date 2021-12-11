package kalva.learnings.ads.companies.thoughtspot;

import kalva.learnings.ads.ListNode;
import kalva.learnings.ads.TreeNode;

public class LLToBST {

    static ListNode head;

    static TreeNode sortedListToBST(int n) {

        if (n <= 0) {
            return null;
        }

        int i = n / 2;
        TreeNode left = sortedListToBST(i);
        TreeNode root = new TreeNode(head.value);
        head = head.next;

        root.left = left;
        i = n - n / 2 - 1;
        root.right = sortedListToBST(i);
        return root;
    }

    static int countNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        head = new ListNode(1);
        head.insert(2).insert(3).insert(4)
                .insert(5).insert(6).insert(7);
        head.printList();

        TreeNode treeNode = sortedListToBST(countNodes(head));
        TreeNode.inOrder(treeNode);
    }
}
