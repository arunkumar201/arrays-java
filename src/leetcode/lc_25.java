package leetcode;

public class lc_25 {
	
	public static void main(String[] args) {
		lc_25 solution = new lc_25();
		int k = 3;
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		System.out.println("Result: " + solution.reverseKGroup_bruteForce(head, k));
	}
	
	private static ListNode getKthNode(ListNode current, int k) {
		while (current != null && k > 0) {
			k--;
			current = current.next;
		}
		return current;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prevGroupEnd = dummy;
		
		
		int count = 0;
		while (true) {
			ListNode kthNode = getKthNode(prevGroupEnd, k);
			
			if (kthNode == null) {
				break;
			}
			
			ListNode groupStart = prevGroupEnd.next;
			ListNode groupEnd = kthNode;
			ListNode nextGroupStart = groupEnd.next;
			
			//reverse the group
			ListNode prev = nextGroupStart;
			ListNode current = groupStart;
			
			while (current != nextGroupStart) {
				ListNode temp = current.next;
				current.next = prev;
				prev = current;
				current = temp;
			}
			
			prevGroupEnd.next = nextGroupStart;
			prevGroupEnd = nextGroupStart;
			
		}
		
		return dummy.next;
	}
	
	
	public ListNode reverseKGroup_bruteForce(ListNode head, int k) {
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prevGroupEndNode = dummy;
		
		while (true) {
			
			ListNode kthNode = getKthNode(prevGroupEndNode, k);
			
			if (kthNode == null) {
				break;
			}
			
			ListNode groupStart = prevGroupEndNode.next;
			ListNode groupEnd = kthNode;
			
			//next group startNode
			ListNode nextGroupStart = groupEnd.next;
			
			//reverse the items in the group
			ListNode prev = nextGroupStart;
			ListNode current = groupStart;
			
			while (current != nextGroupStart) {
				ListNode temp = current.next;
				current.next = prev;
				prev = current;
				current = temp;
			}
			//update the next group startNode
			prevGroupEndNode.next =groupEnd;
			prevGroupEndNode = groupStart;
			
		}
		return dummy.next;
	}
}
