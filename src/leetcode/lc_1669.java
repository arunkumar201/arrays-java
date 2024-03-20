package leetcode;

import leetcode.ListNode;

import java.util.List;

public class lc_1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tail_list2 = list2;
        ListNode head_list2 = list2;
        while (tail_list2.next != null) {
            tail_list2 = tail_list2.next;
        }
        ListNode start = list1;
        ListNode end = null;
        ListNode start_prev = null;
        ListNode end_prev = null;
        for (int i = 0; i < a; i++) {
            start_prev = start;
            start = start.next;
        }
        for (int i = 0; i < b - a; i++) {
            start = start.next;
        }
        end_prev=start;
        if (start_prev != null) {
            start_prev.next = head_list2;
        }
        tail_list2.next = end_prev.next;

        return list1;
    }

    public static void main(String[] args) {
        // Creating list1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        // Creating list2: 10 -> 11 -> 12
        ListNode list2 = new ListNode(10);
        list2.next = new ListNode(11);
        list2.next.next = new ListNode(12);

        lc_1669 solution = new lc_1669();
        ListNode mergedList = solution.mergeInBetween(list1, 2, 3, list2);

        // Print the merged list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

