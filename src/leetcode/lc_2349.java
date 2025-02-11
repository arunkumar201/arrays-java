package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class lc_2349 {
	public static void main(String[] args) {
		//["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
		//[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
		NumberContainers nc = new NumberContainers();
		nc.change(0, 10);
		nc.change(1, 10);
		nc.change(2, 10);
		nc.change(3, 10);
		nc.change(4, 10);
		nc.change(5, 10);
		System.out.println(nc.find(10));
		nc.change(6, 1);
		System.out.println(nc.find(10));
	}
	
}

class NumberContainers_optimized {
	HashMap<Integer, Integer> index_to_number;
	HashMap<Integer, TreeSet<Integer>> number_to_indexes;
	
	public NumberContainers_optimized() {
		index_to_number = new HashMap<>();
		number_to_indexes = new HashMap<>();
	}
	
	public void change(int index, int number) {
		if (index_to_number.containsKey(index)) {
			int prev_num = index_to_number.get(index);
			number_to_indexes.get(prev_num).remove(index);
			
			if (number_to_indexes.get(prev_num).isEmpty()) {
				number_to_indexes.remove(prev_num);
			}
		}
		
		index_to_number.put(index, number);
		if (!number_to_indexes.containsKey(number)) {
			number_to_indexes.put(number, new TreeSet<>());
		}
		number_to_indexes.get(number).add(index);
	}
	
	public int find(int number) {
		
		if (!number_to_indexes.containsKey(number)) {
			return -1;
		}
		//key is the priority queue which contains the indexes of the number (min heap)
		TreeSet<Integer> indexes = number_to_indexes.get(number);
		return indexes.getFirst();
	}
}


class NumberContainers {
	HashMap<Integer, Integer> index_to_number;
	HashMap<Integer, PriorityQueue<Integer>> number_to_indexes;
	
	public NumberContainers() {
		index_to_number = new HashMap<>();
		number_to_indexes = new HashMap<>();
	}
	
	public void change(int index, int number) {
		if (index_to_number.containsKey(index) && index_to_number.get(index) == number)
			return;
		index_to_number.put(index, number);
		number_to_indexes.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
	}
	
	public int find(int number) {
		if (!number_to_indexes.containsKey(number))
			return -1;
		PriorityQueue<Integer> pq = number_to_indexes.get(number);
		// Remove the index of the current number if it exists in the priority queue
		while (!pq.isEmpty() && index_to_number.get(pq.peek()) != number)
			pq.poll();
		return pq.isEmpty() ? -1 : pq.peek();
	}
}