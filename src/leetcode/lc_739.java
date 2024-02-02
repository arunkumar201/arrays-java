package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class lc_739 {

    public static int[] dailyTemperatures1(int[] temperatures) {
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


    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        Stack<Integer> st = new Stack<Integer>();
        ans[len - 1] = 0;
        st.push(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] temperature = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] ans = dailyTemperatures(temperature);

        System.out.println(Arrays.toString(ans));


    }
}
