package algorithms.q0007;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        int number = 123;
        int result = solution.reverse(number);
        assertEquals(321, result);
    }

    @Test
    public void testReverse100() {
        int number = 100;
        int result = solution.reverse(number);
        assertEquals(1, result);
    }

    @Test
    public void testReverse_123() {
        int number = -123;
        int result = solution.reverse(number);
        assertEquals(-321, result);
    }

    @Test
    public void testReverse9646324351() {
        int number = 1534236469;
        int result = solution.reverse(number);
        assertEquals(0, result);
    }

    @Test
    public void testReverse_2147483648() {
        int number = -2147483648;
        int result = solution.reverse(number);
        assertEquals(0, result);
    }

}
