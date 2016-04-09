package algorithms.q0206;

/**
 * Created by rjiang on 3/30/16.
 */
public class Solution002 implements Solution {
    @Override
    public ListNode reverseList(ListNode head) {
        if(null == head) {
            return head;
        }
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (null != currentNode.next) {
            ListNode next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        currentNode.next = previousNode;
        return currentNode;
    }
}
