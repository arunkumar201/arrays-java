package leetcode;

import java.util.Arrays;

public class lc_2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        //Input: seats = [3,1,5], students = [2,7,4]
        int[] seats = new int[]{3, 1, 5};
        int[] students = new int[]{2, 7, 4};
        int res = new lc_2037().minMovesToSeat(seats, students);
        System.out.println(res);
    }
}
