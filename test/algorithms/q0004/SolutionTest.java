package algorithms.q0004;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void initialize() {
        solution = new Solution001();
    }

    @Test
    public void testFindMedianSortedArrays_9() throws Exception {
        int[] m = new int[] {
                2, 3, 4, 5, 6
        };

        int[] n = new int[] {
                2, 4, 5, 6
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(4.0, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_10() throws Exception {
        int[] m = new int[] {
                2, 3, 4, 5, 6
        };

        int[] n = new int[] {
                7, 8, 9, 10, 12
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(6.5, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_1() throws Exception {
        int[] m = new int[] {

        };

        int[] n = new int[] {
            7
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(7.0, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_1_reverse() throws Exception {
        int[] m = new int[] {
            7
        };

        int[] n = new int[] {
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(7.0, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_7() throws Exception {
        int[] m = new int[] {
                1
        };

        int[] n = new int[] {
                2, 3, 4, 5, 6, 7
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(4, result, 0.01);
    }


    @Test
    public void testFindMedianSortedArrays_8() throws Exception {
        int[] m = new int[] {
                4
        };

        int[] n = new int[] {
              1, 2, 3, 5, 6, 7, 8
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(4.5, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_2() throws Exception {
        int[] m = new int[] {

        };

        int[] n = new int[] {
                2, 3
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(2.5, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_2_reverse() throws Exception {
        int[] m = new int[] {
                2, 3
        };

        int[] n = new int[] {

        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(2.5, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_4_reverse() throws Exception {
        int[] m = new int[] {
                1, 2, 4
        };

        int[] n = new int[] {
                3
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(2.5, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_4_repeat() throws Exception {
        int[] m = new int[] {
                1, 2
        };

        int[] n = new int[] {
                1, 2
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(1.5, result, 0.01);
    }

    @Test
    public void testFindMedianSortedArrays_3() throws Exception {
        int[] m = new int[] {
                2, 3
        };

        int[] n = new int[] {
                1
        };
        double result = solution.findMedianSortedArrays(m, n);
        assertEquals(2, result, 0.01);
    }

}