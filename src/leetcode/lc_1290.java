package leetcode;

public class lc_1290 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		lc_1290 solution = new lc_1290();
		System.out.println("Result: " + solution.getDecimalValue(head));
	}
	
	public int getDecimalValue(ListNode head) {
		int result = head.val;
		
		while (head.next != null) {
			result = (result << 1) + head.next.val;
			head = head.next;
		}
		return result;
		
	}
	
	public int getDecimalValue_bruteForce(ListNode head) {
		int result = 0;
		ListNode current = head;
		ListNode prev = null;
		
		//reverse the list
		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		int i = 0;
		//construct the result
		while (prev != null) {
			result += (int) (Math.pow(2, i) * prev.val);
			i++;
			prev = prev.next;
		}
		return result;
	}
}
