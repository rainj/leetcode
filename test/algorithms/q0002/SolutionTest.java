package algorithms.q0002;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = null;

    @Before
    public void initialize() {
        this.solution = new Solution001();
    }

    ListNode buildNode(int[] nums) {

        class ListNodeBuilder {
            ListNode head = null;
            ListNode tail = null;

            ListNodeBuilder(int number) {
                head = new ListNode(number);
                tail = head;
            }

            ListNodeBuilder addNode(int number) {
                tail.next = new ListNode(number);
                tail = tail.next;
                return this;
            }
            ListNode build() {
                return this.head;
            }
        }

        ListNodeBuilder builder = new ListNodeBuilder(nums[0]);
        for(int i = 1; i < nums.length; i ++) {
            builder.addNode(nums[i]);
        }
        return builder.build();
    }

    String stringfyListNode(ListNode head) {
        String delimiter = "->";
        ListNode node = head;
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(node.val).append(delimiter);
        while(node.next != null) {
            node = node.next;
            strBuilder.append(node.val).append(delimiter);
        }
        strBuilder.setLength(strBuilder.length() - delimiter.length());
        return strBuilder.toString();
    }

    @Test
    public void testAddTwoNumbers() throws Exception {
        ListNode l1 = buildNode(new int[]{
                2, 4, 3
        });

        ListNode l2 = buildNode(new int [] {
                5, 6, 4
        });

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals("7->0->8", stringfyListNode(result));
    }

    @Test
    public void testAddTwoNumbers2() throws Exception {
        ListNode l1 = buildNode(new int[]{
                2, 4
        });

        ListNode l2 = buildNode(new int [] {
                5, 6, 4
        });

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals("7->0->5", stringfyListNode(result));
    }

    @Test
    public void testAddTwoNumbers3() throws Exception {
        ListNode l1 = buildNode(new int[]{
                2, 4
        });

        ListNode l2 = buildNode(new int [] {
                5, 6, 9, 9
        });

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals("7->0->0->0->1", stringfyListNode(result));
    }
}