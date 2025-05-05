package leetcode;

import java.util.Arrays;

public class lc_838 {
	
	
	public static void main(String[] args) {
		// dominoes = "RR.L"
		String dominoes = ".L.R...LR..L..";
		String res = new lc_838().pushDominoes(dominoes);
		System.out.println(res);
		
	}
	
	public String pushDominoes(String dominoes) {
		StringBuilder result = new StringBuilder();
		int n = dominoes.length();
		int[] forces = new int[n];
		
		// forces going from left to right
		int force = 0;
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			if (dominoes.charAt(i) == 'R') {
				force = n;
			} else if (dominoes.charAt(i) == 'L') {
				force = 0;
			} else {
				force = Math.max(force - 1, 0);
			}
			forces[i] += force;
		}
//		System.out.println(Arrays.toString(forces));
		
		// forces going from right to left
		force = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (dominoes.charAt(i) == 'L') {
				force = n;
			} else if (dominoes.charAt(i) == 'R') {
				force = 0;
			} else {
				force = Math.max(force - 1, 0);
			}
			forces[i] -= force;
		}
//		System.out.println(Arrays.toString(forces));
		
		for (int f : forces)
			result.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
		
		return result.toString();
	}
	
	public String pushDominoesBruteForce(String dominoes) {
		StringBuilder result = new StringBuilder();
		int n = dominoes.length();
		int[] dominoArray = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (dominoes.charAt(i) == 'R') {
				dominoArray[i] = 1;
			} else if (dominoes.charAt(i) == 'L') {
				dominoArray[i] = 0;
			} else {
				dominoArray[i] = -1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (dominoArray[i] == 1) {
				result.append("R");
			} else if (dominoArray[i] == 0) {
				result.append("L");
			} else {
				int distR = Integer.MAX_VALUE;
				int distL = Integer.MAX_VALUE;
				
				// left for R
				for (int j = i - 1; j >= 0; j--) {
					if (dominoArray[j] == 1) {
						distR = i - j;
						break;
					} else if (dominoArray[j] == 0) {
						break;
					}
				}
				
				// right for L
				for (int j = i + 1; j < n; j++) {
					if (dominoArray[j] == 0) {
						distL = j - i;
						break;
					} else if (dominoArray[j] == 1) {
						break;
					}
				}
				
				if (distR < distL) {
					result.append("R");
				} else if (distL < distR) {
					result.append("L");
				} else {
					result.append(".");
				}
			}
		}
		
		return result.toString();
	}
	
}
