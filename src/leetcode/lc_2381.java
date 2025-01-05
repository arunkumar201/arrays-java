package leetcode;

import java.util.Arrays;

public class lc_2381 {
	
	
	public static void main(String[] args) {
		String s = "dztz";
		int[][] shifts = {{0, 0, 0}, {1, 1, 1}};
		String res = new lc_2381().shiftingLetters_optimized(s, shifts);
		System.out.println("result " + res);
		
		
	}
	
	public String shiftingLetters(String s, int[][] shifts) {
    char[] ch = s.toCharArray();
    
    for (int[] shift : shifts) {
        int start = shift[0];
        int end = shift[1];
        int direction = shift[2];
        
        for (int j = start; j <= end; j++) {
            char c = ch[j];
            int ascii = (c - 'a' + (direction == 1 ? 1 : 25)) % 26;
            ch[j] = (char) (ascii + 'a');
        }
    }
    
    return new String(ch);
}

public String shiftingLetters_optimized(String s, int[][] shifts) {
    char[] ch = s.toCharArray();
//    int n = ch.length;
    
    
    return new String(ch);
}
}
