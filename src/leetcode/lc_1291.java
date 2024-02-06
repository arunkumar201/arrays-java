package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_1291 {

 public static List<Integer> sequentialDigits(int low, int high) {
     List<Integer> result = new ArrayList<>();
     String digits ="123456789";
     int len=digits.length();
     int maxLen=String.valueOf(high).length();
     for(int i=1;i<=maxLen;i++){

         for(int start=0;start<=len-i;start++){
             int num = Integer.parseInt(digits.substring(start,start+i));
             System.out.println(num);
             if(num>=low && num<=high){
                 result.add(num);
             }
         }
     }

     return result;
 }

    public static void main(String[] args) {
        int low=1000;
        int high=13000;
        List<Integer> res=sequentialDigits(low,high);
        System.out.println(res);

    }
}
