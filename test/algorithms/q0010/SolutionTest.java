package algorithms.q0010;

import static org.junit.Assert.assertFalse;
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
	public void testRegularMatch() {
		assertFalse(solution.isMatch("aa", "a"));
		assertTrue(solution.isMatch("aa", "aa"));
		assertFalse(solution.isMatch("aaa", "aa"));
		assertTrue(solution.isMatch("a", "ab*"));
	}

	@Test
	public void testWildPatternMatch() {
		assertTrue(solution.isMatch("aa", "a*"));
		assertTrue(solution.isMatch("aa", ".*"));
		assertTrue(solution.isMatch("ab", ".*"));
		assertFalse(solution.isMatch("ab", ".*c"));
		assertTrue(solution.isMatch("aab", "c*a*b"));
		assertTrue(solution.isMatch("aaa", "a*a"));
		assertTrue(solution.isMatch("aaa", "aa*a"));
		assertTrue(solution.isMatch("aaa", "ab*a*c*aa"));

	}

	@Test
	public void testComplicatWild() {
		assertTrue(solution.isMatch("abbcdefsadfdddddf", "aba*bcdd*efs*sadfd*df"));
		assertTrue(solution.isMatch("abcdabcaba", ".*ab.*aba"));
		assertTrue(solution.isMatch("abcdeabcd", ".*abcd"));
		assertTrue(solution.isMatch("abbbccccd", "a*b*c*d"));
		assertTrue(solution.isMatch("abcdeabcdeabcdeabcde", "abc.*bcd.*cde.*"));
	}

}
