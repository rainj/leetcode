package algorithms.q0200;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SolutionTest {

	Solution solution;

	@Before
	public void setUp() {
		solution = new Solution002();
	}

	@Test
	public void tesCountIsLand() {
		char[][] map = new char[][] {
			"11000".toCharArray(),
			"11000".toCharArray(),
			"00100".toCharArray(),
			"00011".toCharArray()
		};
		assertEquals(3, solution.numIslands(map));
	}

	@Test
	public void tesCountIsLand2() {
		char[][] map = new char[][] {
			"11110".toCharArray(),
			"11010".toCharArray(),
			"11000".toCharArray(),
			"00000".toCharArray()
		};
		assertEquals(1, solution.numIslands(map));
	}
	
}
