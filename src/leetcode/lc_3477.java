package leetcode;

public class lc_3477 {
	
	public static void main(String[] args) {
		//Input: fruits = [4,2,5], baskets = [3,5,4] - 1
		//Input: fruits = [3,6,1], baskets = [6,4,7]- 0
		//Input: fruits = [1,2,1], baskets = [3,2,2]- 0
		
		int[] fruits = {1, 2, 1};
		int[] baskets = {3, 2, 2};
		lc_3477 lc = new lc_3477();
		System.out.println("Brute Force");
		int res = lc.numOfUnplacedFruits_bruteForce(fruits, baskets);
		System.out.println(res);
		System.out.println("Optimized");
		res = lc.numOfUnplacedFruits(fruits, baskets);
		System.out.println(res);
		
		
	}
	
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int len = fruits.length;
		
		int possiblePlacements = 0;
		for (int fruit : fruits) {
			for (int i = 0; i < len; i++) {
				if (fruit <= baskets[i]) {
					possiblePlacements++;
					baskets[i] = 0;
					break;
				}
			}
		}
		return len - possiblePlacements;
	}
	
	
	public int numOfUnplacedFruits_bruteForce(int[] fruits, int[] baskets) {
		
		int[] arr = new int[1001];
		int len = fruits.length;
		int possiblePlacements = 0;
		for (int fruit : fruits) {
			//can be placed in baskets
			for (int i = 0; i < len; i++) {
				if (fruit <= baskets[i] && arr[i] == 0) {
					arr[i] = 1;
					possiblePlacements++;
					break;
				}
			}
		}
		return len - possiblePlacements;
	}
}
