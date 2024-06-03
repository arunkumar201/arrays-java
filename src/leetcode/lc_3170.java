package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_3170 {


public String clearStars(String s) {
    if (!s.contains("*"))
        return s;

    PriorityQueue<Character> pq = new PriorityQueue<>();

    StringBuilder result = new StringBuilder();

    // Iterate through each character in the string
    for (char c : s.toCharArray()) {
        if (c != '*') {
            // If the character is not an asterisk, append it to the result
            result.append(c);
            // Add the character to the priority queue
            pq.offer(c);
        } else if (!pq.isEmpty()) {
            // If the character is an asterisk and the priority queue is not empty
            // Remove the smallest character from the priority queue
            char smallestChar = pq.poll();
            // Remove the last occurrence of the smallest character from the result
            result.deleteCharAt(result.lastIndexOf(String.valueOf(smallestChar)));
        }
    }

    return result.toString();
}


    public static void main(String[] args) {
//        Input:
//        s = "aaba*"

        String s = "c*zb";
        String res = new lc_3170().clearStars(s);
        System.out.println(res);


    }


}
