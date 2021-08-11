package kalva.learnings.ads.fastnslowptr;

import static kalva.learnings.ads.fastnslowptr.ListNode.findMiddle;
import static kalva.learnings.ads.fastnslowptr.ListNode.reverseNode;

/**
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList
 * such that the nodes from the second half of the LinkedList are inserted alternately
 * to the nodes from the first half in reverse order.
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 * <p>
 * Your algorithm should not use any extra space and the input LinkedList
 * should be modified in-place.
 * <p>
 * Example 1:
 * <p>
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
 * Example 2:
 * <p>
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */
public class RearrangeList {

    public static void reorder(ListNode head) {

        ListNode middle = findMiddle(head);

        ListNode temp;
        ListNode first = head;
        ListNode second = reverseNode(middle);

        while (first != null && second != null) {

            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        if (first != null) {
            first.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(2);
        RearrangeList.reorder(head);
        head.printList();
    }
}
