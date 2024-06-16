package leetcode;

import java.util.HashMap;

public class weekly_402 {

    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            int sum = hours[i];
            for (int j = i + 1; j < hours.length; j++) {
                sum += hours[j];
                System.out.println("Sum: " + sum);
                if (sum % 24 == 0) {
                    count++;
                }
                sum = hours[i];
            }
        }
        return count;
    }

    public long countCompleteDayPairs_long(int[] hours) {
        int n = hours.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int hour : hours) {
            int rem = hour % 24;
            int compliment = (24 - rem) % 24;
            if (map.containsKey(compliment)) {
                count += map.get(compliment);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        //Input: hours = [12,12,30,24,24]
        //output:2
        int[] hours = {21, 30, 3,27};
        long totalPairs = new weekly_402().countCompleteDayPairs_long(hours);
        System.out.println("Total pairs: " + totalPairs);

    }
}
