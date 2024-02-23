package leetcode;

import java.util.*;

public class lc_49 {

    //    Given an array of strings strs, group the anagrams together.
//    You can return the answer in any order.
//An Anagram is an word or phrase formed by rearranging the letters of a different
//    word or phrase, typically using all the original letters exactly once.
    public static List<List<String>> groupAnagrams(String[] str) {
//        System.out.println(Arrays.toString(str));
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            int[] countArr = new int[26];
            for (int j = 0; j < s.length(); j++) {
                countArr[s.charAt(j) - 'a']++;
            }
//            System.out.println(Arrays.toString(countArr));
            String countStr = Arrays.toString(countArr);
            if (map.containsKey(countStr)) {
                map.get(countStr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(countStr, list);
            }
        }
//        System.out.println(map);
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {

        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(str);
        System.out.println(res);

    }
}
