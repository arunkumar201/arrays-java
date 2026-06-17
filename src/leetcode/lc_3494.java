package leetcode;

import java.util.Arrays;

public class lc_3494 {

	public static void main(String[] args) {
		/// Input: skill = [1,5,2,4], mana = [5,1,4,2]
		int[] skill = { 1, 5, 2, 4 };
		int[] mana = { 5, 1, 4, 2 };
		lc_3494 lc_3494 = new lc_3494();
		System.out.println(lc_3494.minTime(skill, mana));

	}

	public long minTime(int[] skill, int[] mana) {
		int n = skill.length;
		int m = mana.length;

		// finishTime[] - which hold the finish time for each wizard i to finish the
		// potion
		long[] finishTime = new long[n];

		// iterate through each potion(mana) as here mana represents value
		for (int i = 0; i < m; i++) {
			long currentMana = mana[i];
			// move the potion through each wizard to find the finish time
			// First wizard always works sequentially
			finishTime[0] += (long) currentMana * skill[0];
			// other wizards can work in parallel
			// Each next wizard waits for both themselves and the previous wizard
			for (int j = 1; j < n; j++) {
				finishTime[j] = Math.max(finishTime[j], finishTime[j - 1])+ (long) currentMana * skill[j];
			}
			// now we need to synchronize the finish time or correct the finish time for
			// each wizard from
			// last to start
			System.out.println("before sync " + Arrays.toString(finishTime));
			for (int k = n - 1; k > 0; k--) {
				finishTime[k - 1] = finishTime[k] - (long) currentMana * skill[k];
			}
			System.out.println("after sync " + Arrays.toString(finishTime));
			System.out.println("---------");
		}
		return finishTime[n - 1];
	}

}
