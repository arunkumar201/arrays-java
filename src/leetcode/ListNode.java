package leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public static boolean DisplayList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
        return sb.toString().equals("Empty");
    }
}
