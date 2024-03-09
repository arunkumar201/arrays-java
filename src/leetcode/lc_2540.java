package leetcode;

public class lc_2540 {

    public int getCommon(int[] nums1, int[] nums2) {
    int n1=nums1.length;
    int n2=nums2.length;
    int p1=0;
    int p2=0;
    int MIN_VALUE=Integer.MAX_VALUE;
    while(p1<n1 && p2<n2){
        if(nums1[p1]==nums2[p2]){
            return nums1[p1];
        }else if(nums1[p1]<nums2[p2]){
            p1++;
        }else{
            p2++;
        }
    }
        return  - 1;

    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        int res = new lc_2540().getCommon(arr1, arr2);
        System.out.println(res);
    }
}
