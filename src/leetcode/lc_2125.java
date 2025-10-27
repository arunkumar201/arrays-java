package leetcode;

public class lc_2125 {
	
	public static void main(String[] args) {
		// Input: bank = ["011001","000000","010100","001000"]
		String[] bank = {"011001","000000","010100","001000"};
		lc_2125 lc_2125 = new lc_2125();
		System.out.println(lc_2125.numberOfBeams_bruteForce(bank));

	}
	
	public int numberOfBeams_bruteForce(String[] bank) {
		int totalLaserBeams = 0;
		int n = bank.length;

		for (int i = 0; i < n; i++) {
			int currRowLasers = 0;
			for (char c : bank[i].toCharArray()) {
				if (c == '1') {
					currRowLasers++;
				}
			}
			if (currRowLasers == 0)
				continue;

			for (int j = i + 1; j < n; j++) {
				int nextRowLasers = 0;
				for (char c : bank[j].toCharArray()) {
					if (c == '1') {
						nextRowLasers++;
					}
				}
				if (nextRowLasers == 0) {
					continue;
				} else {
					totalLaserBeams += currRowLasers * nextRowLasers;
					break;
				}
			}
		}
		return totalLaserBeams;

	}

	
	
	public int numberOfBeams_better(String[] bank) {
		int totalLaserBeams = 0;

		int n = bank.length;

		int[] laserCount = new int[n + 1];

		for (int i = 0; i < n; i++) {
			int currRowLasers = 0;
			for (int j = 0; j < bank[i].length(); j++) {
				if (bank[i].charAt(j) == '1') {
					currRowLasers++;
				}
			}
			laserCount[i] = currRowLasers;
		}

		for (int i = 0; i < n; i++) {
			if (laserCount[i] == 0)
				continue;
			for (int j = i + 1; j < n; j++) {
				if (laserCount[j] == 0)
					continue;
				totalLaserBeams += laserCount[i] * laserCount[j];
				break;
			}
		}
		return totalLaserBeams;
	}

	public int numberOfBeams_optimal(String[] bank) {
		int prevLasers = 0;
		int totalLaserBeams = 0;

		for (String row : bank) {
			int currRowLasers = 0;
			
			for (int i = 0; i < row.length(); i++) {
				if (row.charAt(i) == '1') {
					currRowLasers++;
				}
			}
			
			if (currRowLasers == 0)
				continue;
			totalLaserBeams += prevLasers * currRowLasers;
			prevLasers = currRowLasers;
		}
		return totalLaserBeams;
	}

}
