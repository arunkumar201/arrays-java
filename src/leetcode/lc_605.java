package leetcode;

import java.util.Arrays;

public class lc_605 {

    public boolean canPlaceFlowers_1(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int[] modifyFlower = new int[size + 2];
        for (int j = 1; j < modifyFlower.length - 1; j++) {
            modifyFlower[j] = flowerbed[j - 1];
        }
        for (int i = 1; i < modifyFlower.length - 1; i++) {
            if (modifyFlower[i] == 0 && modifyFlower[i + 1] == 0 && modifyFlower[i - 1] == 0) {
                n--;
                modifyFlower[i] = 1;
            }
        }
        return n <= 0;
    }

    public  boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i=0;i<flowerbed.length;i++){
           int prev=i==0?0:flowerbed[i-1];
           int next=i==flowerbed.length-1?0:flowerbed[i+1];
           if(flowerbed[i]==0 && prev==0 && next==0){
               flowerbed[i]=1;
               n--;
           }
        }
        return n<=0;

    }


    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 1;
        boolean res = new lc_605().canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }
}
