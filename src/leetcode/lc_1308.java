package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_1308 {
	   public List<Integer> luckyNumbers (int[][] matrix) {
		   ArrayList<Integer> ans=new ArrayList<>();
		   int m=matrix.length;
		   int n=matrix[0].length;
		   
		   for(int i=0;i<m;i++) {
			   int min=Integer.MAX_VALUE;
			   int index=0;
			   for(int j=0;j<n;j++) {
				   if(matrix[i][j]<min) {
					   min=matrix[i][j];
					   index=j;
				   }
			   }
			   boolean flag=true;
			   for(int k=0;k<m;k++) {
				   if(matrix[k][index]>min) {
					   flag=false;
					   break;
				   }
			   }
			   if(flag) {
				   ans.add(min);
			   }
		   }
		   return ans;
    }
	
	
	
	public static void main(String[] args){
		//Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
		int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        lc_1308 solution = new lc_1308();
        List<Integer> res = solution.luckyNumbers(matrix);
        System.out.println(res);
	}
}
