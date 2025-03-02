package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class lc_426 {
	
	
	public static void main(String[] args) {
		//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
		//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
		//Output
		//[null, null, null, 1, null, -1, null, -1, 3, 4]
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}
}

class LRUCacheBruteForce {
	int capacity;
	HashMap<Integer, Integer> mp;  //handle get , put
	//but I need to keep track of least and most used keys
	//so if capacity get exceeded then I should be able to remove the least used key,
	//so I will need a doubly linked list with head and tail
	LinkedList<Integer> li;
	
	public LRUCacheBruteForce(int capacity) {
		this.capacity = capacity;
		mp = new HashMap<>();
		li = new LinkedList<>();
	}
	
	public int get(int key) {
		if (!mp.containsKey(key)) return -1;
		li.removeFirstOccurrence(key);
		li.addFirst(key);
		return mp.get(key);
	}
	
	public void put(int key, int value) {
		if (mp.containsKey(key)) {
			mp.put(key, value);
			li.removeFirstOccurrence(key);
			li.addFirst(key);
			return;
		}
		if (mp.size() >= this.capacity) {
			int lastKey = li.removeLast();
			mp.remove(lastKey);
			
		}
		mp.put(key, value);
		li.addFirst(key);
	}
}


class LRUCache {
	int capacity;
	HashMap<Integer, DoublyLinkedList> mp;  //handle get , put
	DoublyLinkedList head, tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		mp = new HashMap<>();
		//a doubly should have at lest two nodes
		head = new DoublyLinkedList(0, 0);
		tail = new DoublyLinkedList(0, 0);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if (!mp.containsKey(key)) return -1;
		DoublyLinkedList node = mp.get(key);
		moveToHead(node);
		return node.val;
	}
	
	public void removeNode(DoublyLinkedList node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public void addToHead(DoublyLinkedList node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	public void moveToHead(DoublyLinkedList node) {
		removeNode(node);
		addToHead(node);
		
	}
	
	public void put(int key, int value) {
		if (mp.containsKey(key)) {
			DoublyLinkedList node = mp.get(key);
			node.val = value;
			moveToHead(node);
		} else {
			if (mp.size() >= this.capacity) {
				DoublyLinkedList lastNode = tail.prev;
				removeNode(lastNode);
				mp.remove(lastNode.key);
			}
			DoublyLinkedList newNode = new DoublyLinkedList(key, value);
			addToHead(newNode);
			mp.put(key, newNode);
		}
	}
	
	//but I need to keep track of least and most used keys
	//so if capacity get exceeded then I should be able to remove the least used key,
	//so I will need a doubly linked list with head and tail
	static class DoublyLinkedList {
		int key, val;
		DoublyLinkedList prev, next;
		
		DoublyLinkedList(int key, int val) {
			this.key = key;
			this.val = val;
			
		}
	}
}

