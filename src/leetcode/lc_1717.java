package leetcode;

import java.util.Stack;

public class lc_1717 {
    private int removePairs(Stack<Character> stack, char first, char second, int points) {
        int score = 0;
        Stack<Character> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (!tempStack.isEmpty() && tempStack.peek() == second && c == first) {
                tempStack.pop();
                score += points;
            } else {
                tempStack.push(c);
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return score;
    }

    //Brute Force.
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        int res1 = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            stack1.push(c);
            stack2.push(c);
        }
        // Try to remove ab first in stack1
        res += removePairs(stack1, 'a', 'b', x);

        // Now delete remaining  ba from stack1
        res += removePairs(stack1, 'b', 'a', y);

        // Try to remove ba first in stack2
        res1 += removePairs(stack2, 'b', 'a', y);
        // Now delete remaining ab from stack2
        res1 += removePairs(stack2, 'a', 'b', x);

        // Return the maximum score
        return Math.max(res, res1);
    }


    public static void main(String[] args) {
        //Input: s = "cdbcbbaaabab", x = 4, y = 5
        String s = "cdbcbbaaabab";
        int x = 5;
        int y = 4;
        int res = new lc_1717().maximumGain(s, x, y);
        System.out.println(res);
    }
}
