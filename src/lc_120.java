import java.util.*;

public class lc_120 {

	public static void main(String[] args) {
		// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(new lc_120().minimumTotal_bruteForce(triangle));

	}

	public int minimumTotal_bruteForce(List<List<Integer>> triangle) {
		int n = triangle.size();
		int result = 0;
		int root = triangle.get(0).get(0);
		result += root;
		
		return result;
	}
}
