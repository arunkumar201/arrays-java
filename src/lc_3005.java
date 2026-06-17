public class lc_3005 {
	public static void main(String[] args) {
		// Input: nums = [1,2,2,3,1,4]
		// Output: 2
		int[] nums = { 1, 2, 2, 3, 1, 4 };
		lc_3005 lc_3005 = new lc_3005();
		System.out.println(lc_3005.maxFrequencyElements(nums));

	}

	public int maxFrequencyElements(int[] nums) {
		int[] count = new int[101];
		int maxFrequency = 0;

		for (int num : nums) {
			count[num]++;
			maxFrequency = Math.max(maxFrequency, count[num]);
		}

		int maxFrequencyElements = 0;
		for (int i : count) {
			if (i == maxFrequency) {
				maxFrequencyElements += i;
			}
		}
		return maxFrequencyElements;
	}

	public int maxFrequencyElements_onePass(int[] nums) {
		int[] count = new int[101];
		int maxFrequency = 0;
		int maxFrequencyElements = 0;

		for (int num : nums) {
			count[num]++;
			int freq = count[num];

			if (freq > maxFrequency) {
				//found the new maxFrequency 
				maxFrequencyElements = freq;
				maxFrequency = freq;
			} else if (freq == maxFrequency) {
				maxFrequencyElements += freq;
			}
		}
		return maxFrequencyElements;
	}
}
