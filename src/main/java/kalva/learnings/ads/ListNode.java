package kalva.learnings.ads;

import kalva.learnings.ads.linkedlist.ReverseSubList;

public class ListNode {

    public int value = 0;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }

    public ListNode insert(Integer value) {
        ListNode newNode  = new ListNode(value);
        this.next = newNode;
        return next;
    }

    public void printLoop(ListNode loopNode) {
        ListNode temp = loopNode;
        ListNode startNode = loopNode;
        do {
            System.out.print(loopNode.value + "=>");
            loopNode = loopNode.next;
        } while (startNode != loopNode);
        System.out.println(temp.value);
    }

    public void printList() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.value + "=>");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static ListNode createNode() {
        ListNode head = ReverseSubList.fillData();
        head.next.next.next.next.next = new ListNode(6);
        return head;
    }

    public static ListNode reverseNode(ListNode current) {
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createNode();
        node.printList();
        node = ListNode.reverseNode(node);
        node.printList();
    }
}