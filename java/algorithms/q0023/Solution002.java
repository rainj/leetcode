package algorithms.q0023;

public class Solution002 implements Solution {

	@Override
	public ListNode mergeKLists(ListNode[] lists) {
		if (null == lists || lists.length == 0) {
			return null;
		}

		return merge(lists, 0, lists.length - 1);
	}

	ListNode merge(ListNode[] lists, int start, int end) {
		if (end == start) {
			return lists[start];
		}

		int middle = start + (end - start) / 2;
		ListNode headPart = merge(lists, start, middle);
		ListNode tailPart = merge(lists, middle + 1, end);
		return merge(headPart, tailPart);

	}

	ListNode merge(ListNode node1, ListNode node2) {
		ListNode current = new ListNode(Integer.MAX_VALUE);
		ListNode head = current;
		ListNode n1 = node1;
		ListNode n2 = node2;
		while (null != n1 && null != n2) {
			if (n1.val < n2.val) {
				current.next = n1;
				n1 = n1.next;
			} else {
				current.next = n2;
				n2 = n2.next;
			}
			current = current.next;
		}
		while (null != n1) {
			current.next = n1;
			current = current.next;
			n1 = n1.next;
		}

		while (null != n2) {
			current.next = n2;
			current = current.next;
			n2 = n2.next;
		}
		return head.next;
	}

}
