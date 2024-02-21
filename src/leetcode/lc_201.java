package leetcode;

public class lc_201 {
   public int rangeBitwiseAnd(int m, int n) {
       int count=0;
    while(m!=n){
        m=m>>1;
        n=n>>1;
        count++;
    }
        return m<<count;
    }

    public static void main(String[] args) {
        int left = 2147483646;
        int right = 2147483647;
        int res = new lc_201().rangeBitwiseAnd(left, right);
        System.out.println(res);
    }
}
