package linked_list;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head1 = getListNode();
        ListNode head2 = getListNode();

        System.out.println("Result from recursive approach: " + reverseListUsingRecursion(head1));
        System.out.println("Result from iterative approach: " + reverseListUsingIterativeApproach(head2));
    }

    private static ListNode getListNode() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        return node;
    }

    //Time complexity O(n) and memory complexity O(n)
    private static ListNode reverseListUsingIterativeApproach(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Time Complexity O(n) and Memory Complexity O(n)
    public static ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseListUsingRecursion(head.next);
        ListNode next = head.next;
        head.next = null;
        next.next = head;

        return newHead;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        if (next == null) return String.valueOf(val);
        return val + "->" + next;
    }

}
