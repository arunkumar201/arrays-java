package leetcode;

public class lc_100326 {
    public String compressedString(String word) {
        String comp = "";
        int n = word.length();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1) && count < 9) {
                count++;
            } else {
                comp += count;
                comp += word.charAt(i - 1);
                count = 1;
            }
        }
        comp += count;
        comp += word.charAt(n - 1);
        return comp;
    }


    public static void main(String[] args) {
//Input: word = "abcde"
//Output: "1a1b1c1d1e"

        String word = "aaaaaaaaaaaaaabb";
        String res = new lc_100326().compressedString(word);
        System.out.println(res);
    }
}
