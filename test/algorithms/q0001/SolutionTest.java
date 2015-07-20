package algorithms.q0001;

import org.junit.Before;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = null;

    @Before
    public void initialize() {
        this.solution = new Solution001();
    }

    @org.junit.Test
    public void testTwoSum() throws Exception {
        int[] nums = new int[]{
            2, 7, 11, 15
        };

        int[] result = solution.twoSum(nums, 9);

        assertArrayEquals(new int[] {1, 2}, result);
    }
}