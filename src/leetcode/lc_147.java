package leetcode;

public class lc_147 {
	public static void main(String[] args) {
		//Input: head = [4,2,1,3]
		//Output: [1,2,3,4]
		
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		
		lc_147 solution = new lc_147();
		ListNode result = solution.insertionSortList(head);
		
		System.out.println("Result: " + displayLinkedList(result));
	}
	
	private static String displayLinkedList(ListNode result) {
		StringBuilder sb = new StringBuilder();
		while (result != null) {
			sb.append(result.val);
			sb.append("->");
			result = result.next;
		}
		return sb.toString();
	}
	
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		
		ListNode current = head;
		
		while (current != null) {
			ListNode prev = dummy;
			ListNode nextNode = current.next;
			
			// Find the correct position for the current node
			while (prev.next != null && prev.next.val < current.val) {
				prev = prev.next;
			}
			
			// Insert the current node at the correct position
			current.next = prev.next;
			prev.next = current;
			
			// Move to the next node in the original list
			current = nextNode;
		}
		
		return dummy.next;
	}
}
