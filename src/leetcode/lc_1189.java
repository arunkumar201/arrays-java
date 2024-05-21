package leetcode;

import java.util.Arrays;

public class lc_1189 {

    public int maxNumberOfBalloons(String text) {
        int ans = 0;
        int[] balloon = new int[5];
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b':
                    balloon[0]++;
                    break;
                case 'a':
                    balloon[1]++;
                    break;
                case 'l':
                    balloon[2]++;
                    break;
                case 'o':
                    balloon[3]++;
                    break;
                case 'n':
                    balloon[4]++;
                    break;
            }
        }
        balloon[2] = balloon[2] / 2;
        balloon[3] = balloon[3] / 2;

        ans = Math.min(balloon[0], balloon[1]);
        ans = Math.min(ans, balloon[2]);
        ans = Math.min(ans, balloon[3]);
        ans = Math.min(ans, balloon[4]);

        return ans;
    }

    public static void main(String[] args) {
//        Input: text = "loonbalxballpoon"
        String text = "balllllllllllloooooooooon";
        int res = new lc_1189().maxNumberOfBalloons(text);
        System.out.println(res);
    }
}
