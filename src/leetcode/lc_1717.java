package leetcode;

import java.util.Stack;

public class lc_1717 {
    //using stack
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

    private String removePairsUsingTwoPointers(String inputString, char a, char b, int cost) {
        StringBuilder sb = new StringBuilder(inputString);
        int n = inputString.length();
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            sb.setCharAt(j++, sb.charAt(i));

            if (j > 1 &&
                    sb.charAt(j - 2) == a &&
                    sb.charAt(j - 1) == b) {
                j -= 2;
            }
        }
        sb.delete(j, sb.length());
        return sb.toString();
    }

    //Brute Force.
    public int maximumGain(String s, int x, int y) {
//        int res = 0;
        //find maximum score pair
        String maxPair = x > y ? "ab" : "ba";

//        Stack<Character> stack1 = new Stack<>();
//        for (char c : s.toCharArray()) {
//            stack1.push(c);
//        }
        // Try to remove ab first in stack1
//        res += removePairs(stack1, maxPair.charAt(0), maxPair.charAt(1), Math.max(x, y));

        // Now delete remaining  ba from stack1
//        res += removePairs(stack1, maxPair.charAt(1), maxPair.charAt(0), Math.min(x, y));

        //using two pointers
        int res1 = 0;
        int minPoints = Math.min(x, y);
        int maxPoints = Math.max(x, y);
        String tempFirst = removePairsUsingTwoPointers(s, maxPair.charAt(0), maxPair.charAt(1), maxPoints);
        String tempSecond = removePairsUsingTwoPointers(tempFirst, maxPair.charAt(1), maxPair.charAt(0), minPoints);

        res1 += (s.length() - tempFirst.length()) / 2 * maxPoints;
        res1 += (tempFirst.length() - tempSecond.length()) / 2 * minPoints;

        return res1;
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
