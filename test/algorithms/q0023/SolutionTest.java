package algorithms.q0023;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	Solution solution;

	@Before
	public void setUp() {
		solution = new Solution002();
	}

	@Test
	public void testMerge3List() {
		ListNode[] lists = buildListNode(new int[][] {
			{3, 6, 9, 12},
			{ 2, 4, 6, 8 },
			{ 1, 5, 7, 11 }
		});
		ListNode result = solution.mergeKLists(lists);
		assertTrue(listNodeMatch(result, buildListNode(new int[] { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 11, 12 })));

	}

	boolean listNodeMatch(ListNode s, ListNode t) {
		ListNode source = s;
		ListNode target = t;
		while (source != null && target != null && source.val == target.val) {
			source = source.next;
			target = target.next;
		}

		return null == source && null == target;

	}

	ListNode[] buildListNode(int[][] data) {
		ListNode[] result = new ListNode[data.length];
		for(int i = 0; i < data.length; i ++) {
			result[i] = buildListNode(data[i]);
		}
		return result;
	}
	
	ListNode buildListNode(int[] data) {
		ListNode current = new ListNode(0);
		ListNode head = current;
		for (int number : data) {
			current.next = new ListNode(number);
			current = current.next;
		}
		return head.next;
	}

}
