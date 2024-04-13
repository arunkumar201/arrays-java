package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class lc_402 {
    public String removeKdigits(String num, int k) {
        // base case
        if (k == num.length())
            return "0";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
            index++;
        }
        return res.substring(index);
    }

    public static void main(String[] args) {
        // num = "1432219", k = 3
        String num = "10200";
        int k = 1;
        int res = Integer.parseInt(new lc_402().removeKdigits(num, k));
        System.out.println(res);

    }
}
