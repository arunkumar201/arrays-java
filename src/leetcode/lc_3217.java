package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc_3217 {

	public static void main(String[] args) {
		// Input: nums = [1,2,3], head = [1,2,3,4,5]
		int[] nums = { 1, 2, 3 };
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode res = new lc_3217().modifiedList(nums, head);
		ListNode.DisplayList(res);
	}

	public ListNode modifiedList(int[] nums, ListNode head) {

		ListNode dummy = new ListNode(-1);
		// set
		Set<Integer> set = new HashSet<>();

		ListNode next = head;
		ListNode curr = dummy;

		for (int num : nums) {
			set.add(num);
		}

		while (next != null) {
			if (!set.contains(next.val)) {
				curr.next = next;
				curr = curr.next;
				next = next.next;
			} else {
				next = next.next;
				curr.next = next;
			}
		}

		return dummy.next;
	}

	public ListNode modifiedList_optimal(int[] nums, ListNode head) {
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		boolean[] cache = new boolean[max + 1];

		for (int num : nums) {
			cache[num] = true;
		}

		ListNode dummy = new ListNode(-1);
		ListNode next = head;
		ListNode curr = dummy;

		while (next != null) {

			if (!cache[next.val]) {
				curr.next = next;
				curr = curr.next;
				next = next.next;
			} else {
				next = next.next;
				curr.next = next;
			}

		}
		return dummy.next;
	}
}
