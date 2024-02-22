package leetcode;

public class lc_14 {
    public static String longestCommonPrefix(String[] str) {
        if (str.length == 0) {
            return "";
        }
        if (str.length == 1) {
            return str[0];
        }


        String firstStr = str[0];
        int firstLen = firstStr.length();
        int maxCount = 99999999;

        for (int i = 1; i < str.length; i++) {
            int j = 0;
            while (j < firstLen && j < str[i].length() && firstStr.charAt(j) == str[i].charAt(j)) {
                j++;
            }
            maxCount = Math.min(maxCount, j);
        }
        return firstStr.substring(0, maxCount);
    }

    public static void main(String[] args) {
        String[] str = new String[]{""};

        String res = longestCommonPrefix(str);
        System.out.println(res);
    }
}
