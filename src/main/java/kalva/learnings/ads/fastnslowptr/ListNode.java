package kalva.learnings.ads.fastnslowptr;

public class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        return head;
    }

    public static ListNode reverseNode(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static ListNode findMiddle(ListNode head) {
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
