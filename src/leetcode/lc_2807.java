package leetcode;

public class lc_2807 {
	public int getGreatestCommonDivisor(int a, int b) {
		// Loop until b becomes 0
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public ListNode insertGreatestCommonDivisors(ListNode head) {
		//handle some base conditions
		if (head == null || head.next == null) return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode prev = dummy;
		prev = prev.next;
		ListNode curr = head.next;
		while (curr != null) {
			int gcd = getGreatestCommonDivisor(prev.val, curr.val);
			System.out.println("gcd: " + prev.val + "   " + curr.val + " value: " + gcd);
			ListNode newNode = new ListNode(gcd);
			newNode.next = curr;
			prev.next = newNode;
			prev = curr;
			curr = curr.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		//Input: head = [18,6,10,3]
		ListNode head = new ListNode(12);
		head.next = new ListNode(33);
		head.next.next = new ListNode(10);
		head.next.next.next = new ListNode(3);
		ListNode res = new lc_2807().insertGreatestCommonDivisors(head);
		while (res != null) {
			System.out.print(res.val + " -> ");
			res = res.next;
		}
	}
}
