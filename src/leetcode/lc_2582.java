package leetcode;

public class lc_2582 {
    //brute force
    public int passThePillow(int n, int time) {
        int pillowPosition = 1;
        int currentTime = 0;
        boolean isBack = false;
        // time is taken modulo 2n-2 because the pillow completes a round in 2n-2 seconds
        time = time * (2 * n - 2);
        while (currentTime < time) {
            if (!isBack) {
                pillowPosition++;
            } else {
                pillowPosition--;
            }
            if (pillowPosition == 1 || pillowPosition == n) {
                isBack = !isBack;
            }
            currentTime++;
        }
        return pillowPosition;
    }

    public int passThePillow_optimal(int n, int time) {
        int res = 0;
        int completedCycles = time / n - 1;
        System.out.println("completedCycles: " + completedCycles);
        //remaining time after full cycles
        int remainingTime = time % (n - 1);
        System.out.println("remainingTime: " + remainingTime);
        if (completedCycles % 2 == 0) {
            res = remainingTime + 1;
        } else {
            res = n - remainingTime;
        }
        return res;
    }

    public static void main(String[] args) {
        //Input: n = 4, time = 5
        //Output: 2
        int n = 8;
        int time = 9;
        int res = new lc_2582().passThePillow(n, time);
        System.out.println(res);

    }
}
