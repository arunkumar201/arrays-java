package leetcode;

public class lc_2486 {
  public int appendCharacters(String s, String t) {
      int n=s.length();
      int m=t.length();
       int i=0;
       int j=0;
       while(i<n && j<m){
           if(s.charAt(i)==t.charAt(j)){
               i++;
               j++;
           }else{
               i++;
           }
       }
       return m-j;
    }

    public static void main(String[] args) {
//        Input: s = "coaching", t = "coding"

        String s = "coaching";
        String t = "coding";
        int res = new lc_2486().appendCharacters(s, t);
        System.out.println(res);

    }
}
