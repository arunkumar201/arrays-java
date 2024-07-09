package leetcode;

public class lc_1701 {

    public double averageWaitingTime(int[][] customers) {
        double avgWaitingTime = 0;
        double curTime = 0;
        int len = customers.length;

        for (int[] customer : customers) {
            double arrivalTime = customer[0];
            double serviceTime = customer[1];

            // If the customer arrives after the chef is available, update curTime
            if (arrivalTime > curTime) {
                curTime = arrivalTime;
            }
            curTime += serviceTime;
            System.out.println("curTime: " + curTime + " arrivalTime: " + arrivalTime + " serviceTime: " + serviceTime);
            avgWaitingTime += curTime - arrivalTime;
            System.out.println("avgWaitingTime: " + avgWaitingTime);

        }
        return avgWaitingTime / len;
    }

    public static void main(String[] args) {
        //Input: customers = [[1,2],[2,5],[4,3]]
//        int[][] customers = new int[][]{{1, 2}, {2, 5}, {4, 3}};
//        double res = new lc_1701().averageWaitingTime(customers);
//        System.out.println(res);
        //Input: customers = [[5,2],[5,4],[10,3],[20,1]]
        int[][] customers = new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        double res = new lc_1701().averageWaitingTime(customers);
        System.out.println(res);
    }
}
