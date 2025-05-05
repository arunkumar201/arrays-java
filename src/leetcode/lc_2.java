package leetcode;

public class lc_2 {
	
	public static void main(String[] args) {
		//Input: l1 = [2,4,3], l2 = [5,6,4]
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode res = new lc_2().addTwoNumbers(l1, l2);
		System.out.println(leetcode.ListNode.DisplayList(res));
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			sum += carry;
			carry = sum / 10;
			sum = sum % 10;
			
			head.next = new ListNode(sum);
			head = head.next;
		}
		if (carry > 0) {
			head.next = new ListNode(carry);
		}
		return dummy.next;
		
	}
}
