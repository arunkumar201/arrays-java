package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class lc_904 {
	
	
	public static void main(String[] args) {
		//1,2,1
		
		int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
		lc_904 lc = new lc_904();
		int res = lc.totalFruit(fruits);
		System.out.println(res);
		System.out.println("Brute Force");
		res = lc.totalFruit_bruteForce(fruits);
		System.out.println(res);
		System.out.println("Optimized");
		res = lc.totalFruit_optimized(fruits);
		System.out.println(res);
		
	}
	
	public int totalFruit_bruteForce(int[] fruits) {
		int len = fruits.length;
		
		HashSet<Integer> fruitSet = new HashSet<>();
		
		int maxFruits = 0;
		int currentFruits = 0;
		for (int i = 0; i < len; i++) {
			fruitSet.add(fruits[i]);
			currentFruits = 1;
			for (int j = i + 1; j < len; j++) {
				fruitSet.add(fruits[j]);
				if (fruitSet.size() > 2) {
					break;
				}
				currentFruits++;
			}
			maxFruits = Math.max(currentFruits, maxFruits);
			fruitSet.clear();
			
		}
		return maxFruits;
	}
	
	
	public int totalFruit(int[] fruits) {
		int maxFruits = 0;
		Map<Integer, Integer> fruitMap = new HashMap<>();
		int left = 0;
		
		for (int right = 0; right < fruits.length; right++) {
			int currentFruit = fruits[right];
			fruitMap.put(currentFruit, fruitMap.getOrDefault(currentFruit, 0) + 1);
			
			// Shrink the window if more than 2 types of fruits
			while (fruitMap.size() > 2) {
				int leftFruit = fruits[left];
				fruitMap.put(leftFruit, fruitMap.get(leftFruit) - 1);
				if (fruitMap.get(leftFruit) == 0) {
					fruitMap.remove(leftFruit);
				}
				left++; // Shrink window from the left
			}
			
			// Update the maximum fruits collected
			maxFruits = Math.max(maxFruits, right - left + 1);
		}
		
		return maxFruits;
	}
	
	public int totalFruit_optimized(int[] fruits) {
		int maxFruits = 0;
		int[] counter = new int[100001];
		int unique = 0;
		int left = 0;
		int right = 0;
		
		while (right < fruits.length) {
			int currentFruit = fruits[right];
			
			if (counter[currentFruit] == 0) {
				unique++;
			}
			counter[currentFruit]++;
			
			// Shrink the window if more than 2 types of fruits
			while (unique > 2) {
				int leftFruit = fruits[left];
				counter[leftFruit]--;
				if (counter[leftFruit] == 0) {
					unique--;
				}
				left++; // Shrink window from the left
			}
			
			// Update the maximum fruits collected
			maxFruits = Math.max(maxFruits, right - left + 1);
			right++;
			
		}
		return maxFruits;
	}
}
