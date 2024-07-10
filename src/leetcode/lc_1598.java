package leetcode;

import java.util.Stack;

public class lc_1598 {

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        int minOperations = 0;

        for (String s : logs) {
            if (s.equals("../")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!s.equals("./")) {
                stack.push(s);
            }
        }
        minOperations = stack.size();
        return minOperations;
    }

    //without using stack
    public int minOperations2(String[] logs) {
        int minOperations = 0;

        for (String s : logs) {
            if (s.equals("../")) {
                if (minOperations > 0)
                    minOperations--;
            } else if (!s.equals("./")) {
                minOperations++;
            }
        }
        return minOperations;
    }

    public static void main(String[] args) {
        //Input: logs = ["d1/","d2/","../","d21/","./"]
        String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        int res = new lc_1598().minOperations(logs);
        System.out.println(res);
    }
}
