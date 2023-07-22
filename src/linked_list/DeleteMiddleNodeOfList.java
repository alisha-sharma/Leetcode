package linked_list;

public class DeleteMiddleNodeOfList {
    public static void main(String[] args) {
        System.out.println("Result: " + deleteMiddle(getListNode()));
    }

    private static ListNode getListNode() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        return node;
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode p = head, q = head;
        ListNode prev = head;

        while (q != null && q.next != null) {
            prev = p;
            p = p.next;
            q = q.next.next;
        }

        prev.next = p.next;
        System.gc();
        return head;
    }
}
