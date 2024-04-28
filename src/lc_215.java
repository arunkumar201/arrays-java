import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
//        now start pushing items from k th index
        for (int i = k; i < n; i++) {
            if (!minHeap.isEmpty() && nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return !minHeap.isEmpty() ? minHeap.peek() : 0;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int res = new lc_215().findKthLargest(nums, 8);
        System.out.println(res);
    }
}
