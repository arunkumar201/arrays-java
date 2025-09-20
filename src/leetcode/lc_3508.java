package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc_3508 {
	public static void main(String[] args) {

		/**
		 * Your Router object will be instantiated and called as such:
		 * Router obj = new Router(memoryLimit);
		 * boolean param_1 = obj.addPacket(source,destination,timestamp);
		 * int[] param_2 = obj.forwardPacket();
		 * int param_3 = obj.getCount(destination,startTime,endTime);
		 */
		Router router = new Router(10);
		boolean param_1 = router.addPacket(1, 2, 3);
		int[] param_2 = router.forwardPacket();
		int param_3 = router.getCount(1, 1, 2);
		System.out.println("param_1 " + param_1);
		System.out.println("param_2 " + param_2);
		System.out.println("param_3 " + param_3);
	}

}

class Router extends lc_3508 {

	public String generateKey(int source, int destination, int timestamp) {
		return source + "_" + destination + "_" + timestamp;
	}

	class Packet {
		int source;
		int destination;
		int timestamp;

		Packet(int source, int destination, int timestamp) {
			this.source = source;
			this.destination = destination;
			this.timestamp = timestamp;
		}

		public String getKey(int source, int destination, int timestamp) {
			return generateKey(source, destination, timestamp);
		}
	}

	private int memoryLimit;
	Deque<Packet> queue;
	Set<String> set;
	Map<Integer, List<Integer>> destinationMap;

	public Router(int memoryLimit) {
		this.memoryLimit = memoryLimit;
		queue = new ArrayDeque<>();
		set = new HashSet<>();
		destinationMap = new HashMap<>();
	}

	public boolean addPacket(int source, int destination, int timestamp) {
		Packet packet = new Packet(source, destination, timestamp);
		String key = packet.getKey(source, destination, timestamp);
		// check for duplicate packet
		if (set.contains(key)) {
			return false;
		}

		// check for memory limit - rm the oldest packet
		if (queue.size() == memoryLimit) {
			Packet removedPacket = queue.pollFirst();
			if (removedPacket == null) {
				return false;
			}
			String removedKey = removedPacket.getKey(removedPacket.source, removedPacket.destination,
					removedPacket.timestamp);
			set.remove(removedKey);

			List<Integer> list = destinationMap.get(removedPacket.destination);

			if (list != null) {
				// remove first occurrence of timestamp
				int idx = Collections.binarySearch(list, removedPacket.timestamp);
				if (idx >= 0)
					list.remove(idx);
				if (list.isEmpty())
					destinationMap.remove(removedPacket.destination);
			}

		}

		queue.add(packet);
		set.add(key);
		destinationMap.computeIfAbsent(destination, d -> new ArrayList<>()).add(timestamp);
		return true;
	}

	public int[] forwardPacket() {

		// check the queue is not empty
		if (queue.isEmpty()) {
			return new int[] {};
		}

		// get the first packet
		Packet packet = queue.pollFirst();
		String key = packet.getKey(packet.source, packet.destination, packet.timestamp);

		// update destinationMap
		List<Integer> list = destinationMap.get(packet.destination);
		if (list != null) {
			int idx = Collections.binarySearch(list, packet.timestamp);
			if (idx >= 0)
				list.remove(idx);
			if (list.isEmpty())
				destinationMap.remove(packet.destination);
		}

		set.remove(key);
		return new int[] { packet.source, packet.destination, packet.timestamp };

	}

	public int getCount(int destination, int startTime, int endTime) {
		List<Integer> list = destinationMap.get(destination);
		if (list == null || list.isEmpty())
			return 0;

		int idx1 = lowerBound(list, startTime);
		int idx2 = upperBound(list, endTime);
		return idx2 - idx1;
	}

	// first index >= target
	private int lowerBound(List<Integer> list, int target) {
		int l = 0, r = list.size();
		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid) >= target)
				r = mid;
			else
				l = mid + 1;
		}
		return l;
	}

	// first index > target
	private int upperBound(List<Integer> list, int target) {
		int l = 0, r = list.size();
		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid) > target)
				r = mid;
			else
				l = mid + 1;
		}
		return l;
	}
}
