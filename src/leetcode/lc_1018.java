package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_1018 {

	public static void main(String[] args) {
		// Input: nums = [0,1,1]

		lc_1018 obj = new lc_1018();
		System.out.println(obj.prefixesDivBy5(new int[] { 1, 1, 1 }));

	}

	public List<Boolean> prefixesDivBy5(int[] nums) {
		List<Boolean> result = new ArrayList<>();

		int remainder = 0;
		for (int i = 0; i < nums.length; i++) {

			remainder = (remainder * 2 + nums[i]) % 5;
			System.out.println("remainder = " + remainder);
			result.add(remainder == 0);
		}
		return result;
	}
}
