package linked_list;

import java.util.*;

public class MaximumTwinSum {
    public static void main(String[] args) {
        System.out.println("Maximum twin sum is: " + pairSum(getListNode()));
        System.out.println("Maximum twin sum is: " + pairSumUsingRecursion(getListNode()));
        System.out.println("Maximum twin sum is: " + pairSumUsingExtraSpace(getListNode()));
    }

    private static ListNode getListNode() {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        return node;
    }

    //Time complexity O(n), Space complexity O(n), average time and memory
    public static int pairSumUsingExtraSpace(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val;

        ListNode p = head;
        ListNode q = head;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(p.val);

        while (q != null) {
            q = q.next.next;
            p = p.next;
            if (q != null) list.add(p.val);
        }

        int maxSum = Integer.MIN_VALUE;
        int i = list.size() - 1;
        while (p != null) {
            int sum = list.get(i) + p.val;
            if (sum > maxSum) maxSum = sum;
            p = p.next;
            i--;
        }

        return maxSum;
    }

    // Time Complexity O(n) , Space Complexity O(n), beats memory by 98.95% but more time
    public static int pairSum(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val;

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        //LL is not longer used once it is traversed, so space is available through garbage collection
        int len = list.size();
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len / 2; i++) {
            sum = list.get(i) + list.get(len - 1 - i);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // Time Complexity O(n) , Space Complexity O(n) due to recursion , beats time by 99%, but takes more memory
    public static int pairSumUsingRecursion(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val;

        ListNode node = head;
        ListNode prev = null;
        ListNode p = head;
        ListNode q = head;

        while (q != null) {
            q = q.next.next;
            p = p.next;
            node.next = prev;
            prev = node;
            node = p;
        }

        node = prev;
        int maxSum = Integer.MIN_VALUE;
        while (p != null) {
            int sum = node.val + p.val;
            if (sum > maxSum) maxSum = sum;
            node = node.next;
            p = p.next;
        }

        return maxSum;
    }

}
