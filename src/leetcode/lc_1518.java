package leetcode;

public class lc_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxBottlesToDrinkWater = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            maxBottlesToDrinkWater += newBottles;
            int remainingEmptyBottles = emptyBottles % numExchange;
            emptyBottles = remainingEmptyBottles + newBottles;
        }
        return maxBottlesToDrinkWater;
    }

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;

        int res = new lc_1518().numWaterBottles(numBottles, numExchange);
        System.out.println(res);
    }
}
