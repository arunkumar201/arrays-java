package leetcode;

public class lc_58 {

    public int lengthOfLastWord(String s) {
        if (s.length() == 1) {
            return s.equals(" ") ? 0 : 1;
        }
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int res = new lc_58().lengthOfLastWord(s);
        System.out.println(res);

    }
}
