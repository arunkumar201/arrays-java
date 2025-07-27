package leetcode;

import java.util.PriorityQueue;

public class lc_23 {
	
	public static void main(String[] args) {
		// Test input: [[-2, -1, -1, -1], []]
		ListNode[] lists = new ListNode[2];
		lists[0] = createList(new int[]{-2, -1, -1, -1});
		lists[1] = null;
		
		// Brute force
		System.out.println("Brute Force :");
		printList(new lc_23().mergeKLists(lists));
		
		// Optimized
		ListNode[] lists1 = new ListNode[2];
		lists1[0] = createList(new int[]{-2, -1, -1, -1});
		lists1[1] = null;
		System.out.println("\nOptimized :");
		printList(new lc_23().mergeKLists_optimized(lists1));
	}
	
	// Helper: Create list from array
	static ListNode createList(int[] arr) {
		ListNode dummy = new ListNode(-1), curr = dummy;
		for (int val : arr) {
			curr.next = new ListNode(val);
			curr = curr.next;
		}
		return dummy.next;
	}
	
	static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		int n = lists.length;
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		
		//Min priority queue
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		
		for (int i = 0; i < n; i++) {
			while (lists[i] != null) {
				pq.add(lists[i]);
				lists[i] = lists[i].next;
			}
		}
		
		
		while (!pq.isEmpty()) {
			temp.next = pq.poll();
			temp = temp.next;
		}
		temp.next = null;
		
		
		return dummy.next;
	}
	
	ListNode mergeKLists_optimized(ListNode[] lists) {
		
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		ListNode dummy = new ListNode(-1);
		
		//we only add the first node in the priority queue
		//will be handled the rest of nodes of each node list when we pop the node from the queue
		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}
		
		ListNode temp = dummy;
		
		while (!pq.isEmpty()) {
			ListNode minNode = pq.poll();
			temp.next = minNode;
			temp = temp.next;
			
			//add the next node of the minNode to the priority queue
			//we are dynamically adding the next node of the minNode to the priority queue,
			//so it will be process later
			if (minNode.next != null) {
				pq.add(minNode.next);
			}
		}
		
		return dummy.next;
	}
}
