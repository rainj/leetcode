package algorithms.q0002;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution001 implements Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode head = null;
        ListNode tail = null;
        int addition = 0;
        while(n1 != null || n2 != null) {
            int l1Digit = n1 == null ? 0 : n1.val;
            int l2Digit = n2 == null ? 0 : n2.val;
            int sum = l1Digit + l2Digit + addition;
            int digit = sum % 10;
            addition = sum / 10;
            ListNode node = new ListNode(digit);
            if(head == null) {
                head = node;
            }else{
                tail.next = node;
            }
            tail = node;
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }
        if(addition > 0) {
            ListNode node = new ListNode(addition);
            tail.next = node;
        }
        return head;
    }
}
