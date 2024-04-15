import java.util.*;

public class lc_100256 {
    public String findLatestTime(String s) {
//        s = "1?:?4"
        String s1 = "";
        String s2 = "";
        String[] arr = s.split(":");

        if (arr[0].charAt(0) == '?' && arr[0].charAt(1) == '?') {
            s1 = "11";
        } else {
            if (arr[0].charAt(0) == '?') {
                int a = Integer.parseInt(String.valueOf(arr[0].charAt(1)));
                if (a == 1) {
                    s1 = "11";
                } else if (a == 0) {
                    s1 = "10";
                } else {
                    s1 = "0" + arr[0].charAt(1);

                }
            } else if (arr[0].charAt(1) == '?') {
                int b = Integer.parseInt(String.valueOf(arr[0].charAt(0)));
                if (b == 1) {
                    s1 = "11";
                } else if (b == 0) {
                    s1 = "09";
                } else {
                    s1 = "0" + arr[0].charAt(0);
                }
            } else {
                s1 = arr[0];
            }
        }
        if (arr[1].

                charAt(0) == '?' && arr[1].

                charAt(1) == '?') {
            s2 = "59";
        } else {
            if (arr[1].charAt(0) == '?') {
                s2 = "5" + arr[1].charAt(1);
            } else if (arr[1].charAt(1) == '?') {
                s2 = arr[1].charAt(0) + "9";
            } else {
                s2 = arr[1];
            }
        }

        return s1 + ":" + s2;
    }

    //    fun to check a number is prime or not
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public int maximumPrimeDifference(int[] nums) {
//       base condition
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        return Math.max(end - start, 0);
    }

    public long findKthSmallest(int[] coins, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        PriorityQueue<Integer> li = new PriorityQueue<Integer>();
        for (int i = 0; i < coins.length; i++) {
            int j = k;
            int a = 1;
            while (j != 0 || li.size() < k) {
                int x = coins[i] * (a);
                if (!set.contains(x)) {
                    li.add(x);
                    set.add(x);
                }
                j--;
                a++;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            li.poll();
        }
        return li.peek();
    }

    public static void main(String[] args) {
        //nums = [4,2,9,5,3]
//        int[] s = new int[]{4, 8, 2, 8};
//        int res = new lc_100256().maximumPrimeDifference(s);
//        coins = [3,6,9], k = 3
        int[] coins = new int[]{5, 2};
        int k = 7;
        long res = new lc_100256().findKthSmallest(coins, k);
        System.out.println(res);
    }
}
