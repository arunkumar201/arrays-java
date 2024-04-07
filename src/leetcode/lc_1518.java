package leetcode;

public class lc_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottleCount = numBottles;
        int emptyBottleCount = numBottles;
        while (emptyBottleCount >= numExchange) {
            int exchangedFullBottleCount = emptyBottleCount / numExchange;
            totalBottleCount += exchangedFullBottleCount;
            int remEmptyBottleCount = emptyBottleCount - (exchangedFullBottleCount * numExchange);
            emptyBottleCount = exchangedFullBottleCount + remEmptyBottleCount;
        }
        return totalBottleCount;
    }

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;

        int res = new lc_1518().numWaterBottles(numBottles, numExchange);
        System.out.println(res);
    }
}
