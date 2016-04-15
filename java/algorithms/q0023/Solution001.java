package algorithms.q0023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution001 implements Solution {

	@Override
	public ListNode mergeKLists(ListNode[] lists) {
		if (null == lists || lists.length == 0) {
			return null;
		}

		int length = lists.length;
		if (length == 1) {
			return lists[0];
		}

		ListNode current = new ListNode(Integer.MAX_VALUE);
		ListNode head = current;
		ListNode minimalNode = null;
		ListNode savedListNode = current;
		List<ListNode> currentNodeList = new ArrayList<ListNode>(Arrays.asList(lists));
		while (currentNodeList.size() > 0) {
			filterNullNode(currentNodeList);
			minimalNode = null;
			if (0 == currentNodeList.size()) {
				break;
			}
			for (ListNode node : currentNodeList) {
				if (null == minimalNode || node.val < minimalNode.val) {
					minimalNode = node;
					savedListNode = node;
				}
			}
			current.next = new ListNode(minimalNode.val);
			current = current.next;
			for (int i = 0; i < currentNodeList.size(); i++) {
				if (savedListNode == currentNodeList.get(i)) {
					currentNodeList.set(i, savedListNode.next);
				}
			}
		}

		return head.next;
	}

	void filterNullNode(List<ListNode> lists) {
		for (Iterator<ListNode> it = lists.iterator(); it.hasNext();) {
			ListNode node = it.next();
			if (null == node) {
				it.remove();
			}
		}
	}

}
