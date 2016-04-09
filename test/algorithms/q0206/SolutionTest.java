package algorithms.q0206;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rjiang on 3/2/16.
 */
public class SolutionTest {

    Solution solution;

    @Before
    public void initialize() {
        solution = new Solution002();
    }

    @Test
    public void testReverse123() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode reverseHead = solution.reverseList(head);
        assertEquals(reverseHead.val, 3);
        assertEquals(reverseHead.next.val, 2);
        assertEquals(reverseHead.next.next.val, 1);
    }

    @Test
    public void testReverseNull() {
        ListNode reverseHead = solution.reverseList(null);
        assertNull(reverseHead);
    }


}
