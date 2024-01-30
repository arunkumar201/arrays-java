package leetcode;

import java.util.Stack;

public class lc_150 {

    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<String> st = new Stack<String>();
        int res = 0;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int x = Integer.parseInt(st.pop());
                int y = Integer.parseInt(st.pop());
                switch (token) {
                    case "+" -> st.push(String.valueOf(y + x));
                    case "-" -> st.push(String.valueOf(y - x));
                    case "*" -> st.push(String.valueOf(y * x));
                    case "/" -> st.push(String.valueOf(y / x));
                }

            } else {
                st.push(token);
            }
        }
        System.out.println(st.pop());
        return Integer.parseInt(st.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = evalRPN(tokens);
        System.out.println(res);


    }
}
