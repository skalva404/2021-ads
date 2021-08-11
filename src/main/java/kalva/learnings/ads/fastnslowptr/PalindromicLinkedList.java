package kalva.learnings.ads.fastnslowptr;

import static kalva.learnings.ads.fastnslowptr.ListNode.findMiddle;
import static kalva.learnings.ads.fastnslowptr.ListNode.reverseNode;

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {

        ListNode forward = head;
        ListNode middle = findMiddle(head);
        ListNode reverse = reverseNode(middle);
        ListNode reverseCopy = reverse;

        while (null != reverse && null != forward) {
            if (forward.value != reverse.value) {
                break;
            }
            forward = forward.next;
            reverse = reverse.next;
        }

        reverseNode(reverseCopy);
        return null == forward || null == reverse;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        System.out.println("Is palindrome: " + isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
