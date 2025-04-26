import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_2799 {
	
	public static void main(String[] args) {
		//Input: nums = [1,3,1,2,2]
		//Output: 4
		int[] nums = {1, 3, 1, 2, 2};
		System.out.println(new lc_2799().countCompleteSubarrays(nums));
	}
	
	public int countCompleteSubarrays_BruteForce(int[] nums) {
		int result = 0;
		Set<Integer> set = new HashSet<>();
		int n = nums.length;
		for (int num : nums) {
			set.add(num);
		}
		//unique elements
		int totalDistinct = set.size();
		for (int i = 0; i < n; i++) {
			HashSet<Integer> set1 = new HashSet<>();
			for (int j = i; j < n; j++) {
				set1.add(nums[j]);
				if (set1.size() == totalDistinct) {
					result++;
				}
			}
			set1.clear();
		}
		
		return result;
		
	}
	
	public int countCompleteSubarrays(int[] nums) {
		int result = 0;
		int n = nums.length;
		int distinctItems = 0;
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		distinctItems = set.size();
		System.out.println("distinctItems = " + distinctItems);
		
		//we are going use sliding window
		//and target the window at least size of distinctItems
		int left = 0;
		int right = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < n) {
			map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
			while (map.size() == distinctItems) {
				result += n - right;
				map.put(nums[left], map.get(nums[left]) - 1);
				if (map.get(nums[left]) == 0) {
					map.remove(nums[left]);
				}
				left++;
			}
			right++;
			
		}
		return result;
	}
}
