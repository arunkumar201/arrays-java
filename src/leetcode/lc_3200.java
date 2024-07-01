package leetcode;

public class lc_3200 {

    public int maxHeightOfTriangle(int red, int blue) {
        int max = Math.max(red, blue);
        int ans = 0;
        int min = Math.min(red, blue);
        min = min == 0 ? 1 : min;
        int baseRow = (int) Math.floor((double) max / min);

        if (baseRow >= min) {
            ans++;
        }
        ans += baseRow;

        return ans;
    }

    public static void main(String[] args) {
        lc_3200 obj = new lc_3200();
        int red = 2;
        int blue = 1;
        System.out.println(obj.maxHeightOfTriangle(red, blue));
    }
}
