package leetcode;

public class lc_11 {

	public static void main(String[] args) {
		// Input: height = [1,8,6,2,5,4,8,3,7]
		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		// int[] height1 = new int[] { 1, 1, 8, 1, 2, 3 };
		int res = new lc_11().maxArea_bruteForce(height);
		System.out.println(res);
		System.out.println("----better");
		int res1 = new lc_11().maxArea_better(height);
		System.out.println(res1);

	}

	public int maxArea_better(int[] height) {
		int max_area = 0;
		int n = height.length;

		int left = 0;
		int right = n - 1;

		while (right >= left) {

			int start_line_height = height[left];
			int end_line_height = height[right];

			int h = Math.min(start_line_height, end_line_height);

			int width = right - left;
			int curr_area = h * width;

			if (start_line_height < end_line_height) {
				left++;
			} else {
				right--;
			}

			max_area = Math.max(max_area, curr_area);
		}

		return max_area;
	}

	public int maxArea_bruteForce(int[] height) {
		int max_area = 0;
		int n = height.length;

		for (int i = 0; i < n; i++) {
			int start_line_height = height[i];

			for (int j = i + 1; j < n; j++) {
				int curr_area = Math.min(start_line_height, height[j]) * (j - i);
				max_area = Math.max(max_area, curr_area);
			}
		}

		return max_area;

	}

}
