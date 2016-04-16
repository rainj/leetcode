package algorithms.q0025;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class SolutionTest {

	Solution solution;

	@Before
	public void setUp() {
		solution = new Solution001();
	}

	@Test
	public void testMerge3List() {
		ListNode head = buildListNode(new int[] { 1, 2, 3, 4, 5 });
		ListNode to = this.travelTo(head, 4);
//		print(solution.reverseKGroup(head, 3));
		assertTrue(listNodeMatch(solution.reverseKGroup(head, 3), buildListNode(new int[] { 3, 2, 1, 4, 5 })));
	}

	void print(ListNode head) {
		System.out.print(head.val);
		ListNode current = head.next;
		while (current != null) {
			System.out.print("-->" + current.val);
			current = current.next;
		}
		System.out.println();
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
	
	ListNode travelTo(ListNode head, int count) {
		ListNode to = head;
		int c = count;
		while (c > 0) {
			c--;
			to = to.next;
		}
		return to;
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
