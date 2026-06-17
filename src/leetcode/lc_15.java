package leetcode;

import java.util.*;

public class lc_15 {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		lc_15 lc = new lc_15();
		System.out.println("Using Brute Force");
		List<List<Integer>> result = lc.threeSum_BruteForce(nums);
		System.out.println("--------" + result);
		System.out.println("Using Optimal way");
		List<List<Integer>> result2 = lc.threeSum(nums);
		System.out.println("--------" + result2);
		System.out.println("Using HashSet");
		List<List<Integer>> result3 = lc.threeSum_HashSet(nums);
		System.out.println("--------" + result3);

	}

	public List<List<Integer>> threeSum_BruteForce(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		HashSet<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
						temp.sort((a, b) -> a - b);
						set.add(temp);
					}
				}
			}
		}
		for (List<Integer> list : set) {
			result.add(list);
		}
		return result;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();

		// first sort the array
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int a = nums[i];
			// two sum - b+c=-a
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int b = nums[left];
				int c = nums[right];
				int threeSum = a + b + c;
				if (threeSum > 0) {
					right--;
				} else if (threeSum < 0) {
					left++;
				} else {
					List<Integer> temp = new ArrayList<>();
					temp.add(a);
					temp.add(b);
					temp.add(c);
					result.add(temp);
					left++;
					while (left < right && nums[left] == nums[left - 1])
						left++;
				}
			}
		}
		return result;
	}

	// using HashSet
	public List<List<Integer>> threeSum_HashSet(int[] nums) {

		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();

		HashSet<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			HashSet<Integer> lookup = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int third = -(nums[i] + nums[j]);
				if (lookup.contains(third)) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(third);
					// sort the
					temp.sort((a, b) -> a - b);
					set.add(temp);
				}
				lookup.add(nums[j]);
			}
		}
		for (List<Integer> list : set) {
			result.add(list);
		}
		return result;
	}
}
