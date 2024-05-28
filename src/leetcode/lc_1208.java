package leetcode;

import java.util.Arrays;

public class lc_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
     int maxLen=0;
     int n = s.length();
     int[] prefixLen=new int[n];
     for(int i=0;i<n;i++){
         prefixLen[i]=Math.abs(s.charAt(i)-t.charAt(i));
     }
     System.out.println(Arrays.toString(prefixLen));
     int cost=0;
     int left=0;
     for(int right=0;right<n;right++){
         cost+=prefixLen[right];
         while(cost>maxCost){
             cost-=prefixLen[left];
             left++;
         }
         maxLen=Math.max(maxLen,right-left+1);
     }
     return maxLen;
    }

    public static void main(String[] args) {
//     Input: s = "abcd", t = "bcdf", maxCost = 3

        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int res = new lc_1208().equalSubstring(s, t, maxCost);
        System.out.println(res);


    }
}
