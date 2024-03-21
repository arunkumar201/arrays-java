package leetcode;

public class lc_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

        lc_206 solution = new lc_206();

        // Print the merged list
        ListNode current = solution.reverseList(list2);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
