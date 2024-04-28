package leetcode;

public class lc_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String s : word1) s1.append(s);
        for (String s : word2) s2.append(s);

        return s1.compareTo(s2) == 0;
    }

    public static void main(String[] args) {
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        boolean res = new lc_1662().arrayStringsAreEqual(word1, word2);
        System.out.println(res);
    }
}
