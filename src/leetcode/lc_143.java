package leetcode;

import java.util.List;
import java.util.Stack;

public class lc_143 {
    public void reorderList_1(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode curr = head;
        ListNode rev = reverseList(splitList((head)));

        while (curr != null && rev != null && curr != rev) {
            ListNode next = curr.next;
            ListNode nextRev = rev.next;
            curr.next = rev;
            rev.next = next;
            curr = next;
            rev = nextRev;

        }
        if (curr != null) {
            curr.next = null;
        }
    }

    private ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null; // Split the list into two halves

        return secondHalf;
    }

    public ListNode reverseList(ListNode head) {
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


    public void reorderList_using_Stack(ListNode head) {
        if (head == null || head.next == null) return;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
            size++;
        }
        temp = head;
        int count = 0;
        ListNode prev = null;
        ListNode next = null;
        while (count < size / 2) {
            next = temp.next;
            prev = stack.peek();
            temp.next = stack.pop();
            prev.next = next;
            temp = next;
            count++;
        }
        assert next != null;
        next.next = null;

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        //reverse the secondHalf list
        ListNode curr = secondHalf;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next=curr.next;
            curr.next= prev;
            prev=curr;
            curr=next;
        }
        //merge two lists
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
           ListNode temp=first.next;
           ListNode temp1=second.next;
           first.next=second;
           second.next=temp;
           first=temp;
           second=temp1;
        }

    }


    public static void main(String[] args) {
//  ListNode list1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);


        lc_143 solution = new lc_143();
        solution.reorderList(list1);
        while (list1 != null) {
            System.out.print(list1.val + " -> ");
            list1 = list1.next;
        }
        System.out.println("null");
    }


}

