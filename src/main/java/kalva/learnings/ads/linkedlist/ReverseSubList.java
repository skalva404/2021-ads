package kalva.learnings.ads.linkedlist;

import kalva.learnings.ads.ListNode;

public class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {

        ListNode prevP = head;
        while (prevP.next.value != p) {
            prevP = prevP.next;
        }
        ListNode nodeQ = head;
        while (nodeQ.value != q) {
            nodeQ = nodeQ.next;
        }

        ListNode nextQ = nodeQ.next;
        ListNode nodeP = prevP.next;

        //reverse logic
        ListNode prev = null;
        ListNode curr = nodeP;
        while (curr.value != nextQ.value) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prevP.next = nodeQ;
        nodeP.next = nextQ;

        return head;
    }

    public static void main(String[] args) {

        ListNode head = fillData();

        ListNode result = ReverseSubList.reverse(head, 5, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static ListNode fillData() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        return head;
    }
}
