package algorithms.q0025;

public class Solution001 implements Solution {

	@Override
	public ListNode reverseKGroup(ListNode head, int k) {
		if (null == head || 0 == k || 1 == k) {
			return head;
		}
		ListNode theHead = new ListNode(-1);
		theHead.next = head;

		ListNode frame = theHead;
		ListNode current = frame.next;
		ListNode from = null;
		ListNode to = null;
		int count = 0;
		while (null != current) {
			count++;
			current = current.next;
			if (k - 1 == count % k && null != current) {
				from = frame.next;
				to = current;
				frame.next = reverse(from, to, k);
				frame = from;
				current = from;
			}
		}

		return theHead.next;
	}

	/**
	 * 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8
	 * 
	 * @param from
	 * @param to
	 */

	public ListNode reverse(ListNode from, ListNode to, int k) {
		if (k == 1) {
			return from;
		}
		int middle = k >> 1;
		boolean isOdd = (k & 1) > 0;
		ListNode firstFrom = from;
		ListNode firstTo = from;
		ListNode middleNode = null;
		ListNode secondFrom = null;
		ListNode secondTo = to;

		int count = middle - 1;
		while (count > 0) {
			firstTo = firstTo.next;
			count--;
		}
		if (isOdd) {
			middleNode = firstTo.next;
			secondFrom = middleNode.next;
			firstTo.next = secondTo.next;
			secondTo.next = middleNode;
			middleNode.next = firstFrom;
			if (middle > 1) {
				middleNode.next = reverse(firstFrom, firstTo, middle);
				return reverse(secondFrom, secondTo, middle);

			}
		} else {
			secondFrom = firstTo.next;
			firstTo.next = secondTo.next;
			secondTo.next = firstFrom;
			if (middle > 1) {
				secondTo.next = reverse(firstFrom, firstTo, middle);
				return reverse(secondFrom, secondTo, middle);

			}
		}
		return secondFrom;
	}

}
