package linked_list;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        System.out.println("Reordered list: " + oddEvenList(getListNode()));
    }

    private static ListNode getListNode() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        return node;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode evenNode = head.next;
        ListNode even = evenNode;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenNode;

        return head;

    }
}
