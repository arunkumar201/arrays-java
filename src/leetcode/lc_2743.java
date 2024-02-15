package leetcode;


import java.util.HashMap;
import java.util.HashSet;

public class lc_2743 {
    ///new problem
//    https://www.interviewbit.com/problems/colorful-number/
    public static int colorful(int num) {
        if (num < 10) {
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int prod = 1;
            for (int j = i; j < s.length(); j++) {
                System.out.println(s.charAt(j) - '0');
                prod = prod * (s.charAt(j) - '0');
                if (set.contains(prod)) {
                    return 0;
                }
                set.add(prod);
            }

        }
        return 1;
    }

    public static int numberOfSpecialSubstrings(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        int j = 0;
        int i = 0;
        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            while (mp.get(s.charAt(j)) > 1) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                i++;
            }
            ans += j - i + 1;
            j++;

        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "abcd";
        int res = numberOfSpecialSubstrings(s);
        System.out.println("result is " + res);
        int a = 23;
        int res1 = colorful(a);
        System.out.println("result is " + res1);
    }
}
