package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class lc_1823 {
    //using queue - O(n*k) O(N) space
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1 && !queue.isEmpty(); i++) {
                int front = queue.remove();
                queue.add(front);
            }
            queue.remove();
        }
        return queue.peek();
    }

    //using O(N)
    public int findTheWinner_efficient(int n, int k) {
        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;

    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(new lc_1823().findTheWinner_efficient(n, k)); // Output: 3

    }
}
