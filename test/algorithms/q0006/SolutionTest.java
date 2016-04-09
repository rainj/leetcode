package algorithms.q0006;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution;

    @Before
    public void initialize() {
        solution = new Solution001();
    }

    @Test
    public void testConvertStringZigZag1() throws Exception {
        String str = "";
        String result = solution.convert(str, 1);
        assertEquals("", result);
    }

    @Test
    public void testConvertStringZigZag3() throws Exception {
        String str = "PAYPALISHIRING";
        String result = solution.convert(str, 3);
        assertEquals("PAHNAPLSIIGYIR", result);
    }

    @Test
    public void testConvertStringZigZag5() throws Exception {
        String str = "ABCDEFGHIJKLMN";
        String result = solution.convert(str, 5);
        assertEquals("AIBHJCGKDFLNEM", result);
    }

    @Test
    public void testConvertStringZigZag2() throws Exception {
        String str = "ABC";
        String result = solution.convert(str, 2);
        assertEquals("ACB", result);
    }

    @Test
    public void testConvertStringZigZag2_2() throws Exception {
        String str = "ABCD";
        String result = solution.convert(str, 2);
        assertEquals("ACBD", result);
    }

    @Test
    public void testConvertStringZigZag4() throws Exception {
        String str = "ABCDEFGHIJKLMN";
        String result = solution.convert(str, 4);
        assertEquals("AGMBFHLNCEIKDJ", result);
    }

}