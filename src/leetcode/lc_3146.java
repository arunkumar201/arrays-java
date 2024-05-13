package leetcode;

public class lc_3146 {

    public int findPermutationDifference(String s, String t) {
        int res = 0;
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arrS[s.charAt(i) - 'a'] = i;
            arrT[t.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            res += Math.abs(arrS[i] - arrT[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        Input: s = "abc", t = "bac"

        String s = "abcde";
        String t = "edbac";
        int res = new lc_3146().findPermutationDifference(s, t);
        System.out.println(res);
    }


}
