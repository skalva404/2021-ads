package kalva.learnings.ads.linkedlist;

import kalva.learnings.ads.ListNode;

/**
 * Problem Statement #
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public class ReverseEveryKElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.print("Nodes of the reversed LinkedList are: ");
        ListNode loop = head;
        while (loop != null) {
            System.out.print(loop.value + " ");
            loop = loop.next;
        }
        System.out.println();
        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private static ListNode reverse(ListNode head, int k) {

        boolean done = false;
        ListNode prev = null;
        ListNode next = head;
        ListNode start = head;
        ListNode iterater = head;

        ListNode newHead = null;

        do {
            for (int i = 1; i < k; i++) {
                iterater = iterater.next;
                if (null == iterater) {
                    done = true;
                    break;
                }
            }
            if (null != iterater) {
                next = iterater.next;
                iterater.next = null;
            }

            ListNode reverseTail = start;
            ListNode reverseHead = reverseList(start);
            if (null != prev) {
                prev.next = reverseHead;
            }
            prev = reverseTail;
            iterater = next;
            start = iterater;

            if (null == newHead) {
                newHead = reverseHead;
            }
        } while (!done);

        return newHead;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
