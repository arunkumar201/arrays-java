package leetcode;

public class lc_392 {
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n2 < n1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n1;
    }

    public static void main(String[] args) {

        String s = "axc";
        String t = "ahbgdc";
        boolean res = new lc_392().isSubsequence(s, t);
        System.out.println(res);
    }
}
