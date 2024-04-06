package leetcode;

import java.util.Stack;

public class lc_1249 {
    public String minRemoveToMakeValid_Stack(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == ')') {
                if (!st.isEmpty() && str[i] == ')' && str[st.peek()] == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (!st.contains(i)) {
                ans.append(str[i]);
            }
        }
        return ans.toString();
    }

    public String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        StringBuilder ans = new StringBuilder();
        int openBrackets = 0;
        for (char c : str) {
            if (c == '(' || c == ')') {
                if (c == '(') {
                    ans.append(c);
                    openBrackets++;
                } else {
                    if (openBrackets > 0) {
                        ans.append(c);
                        openBrackets--;
                    }
                }
            } else {
                ans.append(c);
            }
        }

        int j = ans.length() - 1;
        while (j >= 0 && openBrackets > 0) {
            if (ans.charAt(j) == '(') {
                ans.deleteCharAt(j);
                openBrackets--;
            }
            j--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        String s1 = "))((";
        String s2 = "a)b(c)d";
        String res = new lc_1249().minRemoveToMakeValid(s1);
        System.out.println("result is " + res);
    }
}
