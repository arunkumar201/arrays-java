package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class lc_739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len == 0) {
            return new int[]{};
        }
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>(); // store the index of the temperature// >

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] temperature = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] ans = dailyTemperatures(temperature);

        System.out.println(Arrays.toString(ans));


    }
}
