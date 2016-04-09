package algorithms.q0206;

/**
 * Created by rjiang on 3/30/16.
 */
public class Solution001 implements Solution{

    @Override
    public ListNode reverseList(ListNode head) {
        return this.reverseList(null, head);
    }

    private ListNode reverseList(ListNode previousNode, ListNode head) {
        if(null == head) {
            return previousNode;
        }
        ListNode next = head.next;
        head.next = previousNode;
        return  reverseList(head, next);
    }
}
