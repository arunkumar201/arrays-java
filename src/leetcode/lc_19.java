package leetcode;

public class lc_19 {
	
	public static void main(String[] args) {
		//Input: head = [1,2,3,4,5], n = 2
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = new lc_19().removeNthFromEnd(head, 2);
		System.out.println(leetcode.ListNode.DisplayList(res));
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode first = dummy;
		ListNode second = dummy;
		
		for (int i = 0; i <= n; i++) {
			first = first.next;
		}
		
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		
		second.next = second.next.next;
		
		return dummy.next;
	}
	
}
