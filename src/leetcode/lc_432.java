package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class lc_432 {
	public static void main(String[] args) {
		//["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
		//[[],["hello"],["hello"],[],[],["leet"],[],[]]
		AllOne allOne = new AllOne();
		allOne.inc("hello");
		allOne.inc("hello");
		System.out.println(allOne.getMaxKey());
		System.out.println(allOne.getMinKey());
		allOne.inc("leet");
		allOne.inc("leet");
		allOne.dec("leet");
		System.out.println(allOne.getMaxKey());
		System.out.println(allOne.getMinKey());
		
	}
}


class AllOne {
	private final TreeSet<String> sortedKeys;
	HashMap<String, Integer> map;
	String maxKey;
	String minKey;
	int maxVal;
	int minVal;
	
	public AllOne() {
		map = new HashMap<>();
		sortedKeys = new TreeSet<>((a, b) -> {
			int countCompare = Integer.compare(map.get(a), map.get(b));
			return countCompare != 0 ? countCompare : a.compareTo(b);
		});
		this.maxVal = Integer.MIN_VALUE;
		this.minVal = Integer.MAX_VALUE;
		this.minKey = "";
		this.maxKey = "";
	}
	
	public void inc(String key) {
//		we need to check if key exist or not -
//		yes - increment their count else add with count =1;
		if (!map.containsKey(key)) {
			map.put(key, 1);
		} else {
			sortedKeys.remove(key);
			int newValue = map.get(key) + 1;
			map.put(key, newValue);
		}
		sortedKeys.add(key);
		
		
	}
	
	public void dec(String key) {
//		same but just opposite - key always exists as per ques
		sortedKeys.remove(key);
		int value = map.get(key);
		if (value == 1) {
			map.remove(key);
		} else {
			map.put(key, value - 1);
			sortedKeys.add(key);
			
		}
		
		updateMaxMin();
		
		
	}
	
	public String getMaxKey() {
//		return this.maxKey;
		//optimized solution
		return sortedKeys.isEmpty() ? "" : sortedKeys.last();
		
		
	}
	
	public String getMinKey() {
//		return this.minKey;
		//optimized solution
		return sortedKeys.isEmpty() ? "" : sortedKeys.first();
		
	}
	
	
	public void updateMaxMin() {
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;
		maxKey = "";
		minKey = "";
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			
			if (value > maxVal) {
				maxVal = value;
				maxKey = key;
			}
			if (value < minVal) {
				minVal = value;
				minKey = key;
			}
		}
	}
	
}


