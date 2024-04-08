package leetcode;

import java.util.HashMap;

public class lc_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = students.length;
        int ans = n;
        for (int student : students) {
            map.put(student, map.getOrDefault(student, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(sandwiches[i], 0) > 0) {
                ans--;
                map.put(sandwiches[i], map.get(sandwiches[i]) - 1);
            } else {
                return ans;
            }
        }
        return ans;
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        int n = students.length;
        int ones = 0; //count of students who ate at typeOne of sandwich
        int zeros = 0; //count of students who ate at typeZero of sandwich
        for (int student : students) {
            if (student == 1) {
                ones++;
            } else {
                zeros++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 0) { //typeZero sandwich
                if (zeros == 0) { //no students want to eat typeZero sandwich
                    return ones;
                }
                zeros--; //eat typeZero sandwich
            } else {
                if (ones == 0) { //no students want to eat typeOne sandwich
                    return zeros;
                }
                ones--; //eat typeOne sandwich
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 1, 0, 0, 1};
        int[] sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        int res = new lc_1700().countStudents(students, sandwiches);
        System.out.println(res);
    }
}
