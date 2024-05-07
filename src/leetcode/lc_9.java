package leetcode;

public class lc_9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        int temp = x;
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return temp == rev;
    }

    public static void main(String[] args) {
        int n = 9;
        boolean ans = new lc_9().isPalindrome(n);
        System.out.println(ans);

    }
}
