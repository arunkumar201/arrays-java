package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class lc_3479 {
	
	public static void main(String[] args) {
		
		//Input: fruits = [4,2,5], baskets = [3,5,4]
		//Input: fruits = [3,6,1], baskets = [6,4,7]
		//Input: fruits = [1,2,1], baskets = [3,2,2]
		
		int[] fruits = {3, 6, 1};
		int[] baskets = {6, 4, 7};
		lc_3479 lc = new lc_3479();
		System.out.println("Brute Force");
		int res = lc.numOfUnplacedFruits_bruteForce(fruits, baskets);
		System.out.println(res);
		System.out.println("Optimized");
		res = lc.numOfUnplacedFruits(fruits, baskets);
		System.out.println(res);
	}
	
	public int numOfUnplacedFruits_bruteForce(int[] fruits, int[] baskets) {
		int n = fruits.length;
		
		int unplacedFruits = 0;
		HashSet<Integer> fruitSet = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			int currentFruitQuantity = fruits[i];
			//check if current fruit with Quantity currentFruitQuantity can be placed in baskets
			//from left to right
			//we are doing repeatedly checking if the current even those which are already placed
			for (int j = 0; j < n; j++) {
				if (currentFruitQuantity <= baskets[j] && !fruitSet.contains(j)) {
					System.out.println(currentFruitQuantity + " " + baskets[j]);
					unplacedFruits++;
					fruitSet.add(j);
					break;
				}
			}
			
		}
		return n - unplacedFruits;
	}
	
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int n = fruits.length;
		int unplacedFruits = 0;
		Map<Integer, Integer> fruitMap = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			int currentFruitQuantity = baskets[i];
			fruitMap.put(i, currentFruitQuantity);
		}
		
		for (int i = 0; i < n; i++) {
			int fruitsToPlace = fruits[i];
			
			
		}
		
		return n - unplacedFruits;
	}
}

