package leetcode;

import java.util.HashSet;

public class lc_3217 {
	
	
	public static void main(String[] args) {
		//Input: nums = [1,2,3], head = [1,2,3,4,5]
		int[] nums = {1, 2, 3};
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = new lc_3217().modifiedList(nums, head);
		ListNode.DisplayList(res);
	}
	
	public ListNode modifiedList(int[] nums, ListNode head) {
		HashSet<Integer> set = new HashSet<>();
		ListNode dummy = new ListNode(0);
		
		for (int num : nums) {
			set.add(num);
		}
		
		ListNode curr = dummy;
		ListNode next = head;
		
		while (next != null) {
				System.out.println(next.val+curr.val);
			if (set.contains(next.val)) {
				next = next.next;
				curr.next = next;
			} else {
				System.out.println(next.val+"--");
				curr.next = next;
				curr=curr.next;
				next = next.next;
			}
		}
		
		
		return dummy.next;
		
	}
}
