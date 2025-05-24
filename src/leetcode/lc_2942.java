package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_2942 {

    public static void main(String[] args) {
        lc_2942 solution = new lc_2942();
        String[] words = new String[]{"apple", "app", "leetcode", "leet", "code"};
        List<Integer> result = solution.findWordsContaining(words, 'e');
        System.out.println("Result: " + result);
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        for (String s : words) {
            if (s.indexOf(x) != -1) {
                res.add(i);
            }
            /*
            // ** we can also use contains method, but it will slower
            if (s.contains(String.valueOf(x))) {
                res.add(i);
            }
            */
            i++;
        }
        return res;
    }
}
