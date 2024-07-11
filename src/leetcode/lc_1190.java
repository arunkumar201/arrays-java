package leetcode;

import java.util.Stack;

public class lc_1190 {
    //using stack Data Structure
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        String res = "";
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuffer temp = new StringBuffer();
                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                stack.pop();
                for (char ch : temp.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        //Input: s = "(u(love)i)"
        String s = "a(bcdefghijkl(mno)p)q";
        String res = new lc_1190().reverseParentheses(s);
        System.out.println(res);
    }
}
