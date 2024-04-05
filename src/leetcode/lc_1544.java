package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class lc_1544 {
    public String makeGood(String s) {
        String ans = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() &&
                    Math.abs(Math.abs(st.peek()) - Math.abs(s.charAt(i))) == 32
            ) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {
            ans = st.pop()+ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        String res = new lc_1544().makeGood(s);
        System.out.println(res);
    }
}
