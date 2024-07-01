package leetcode;

public class lc_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return false;
        }

        for (int i = 0; i < n - 2; i++) {
            if ((arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        lc_1550 obj = new lc_1550();
        int[] arr = {1, 1, 1};
        System.out.println(obj.threeConsecutiveOdds(arr));
    }
}
