package algorithms.q0173;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	BSTIterator solution;

	@Test
	public void testMerge3List() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		solution = new BSTIterator(root);
		while (solution.hasNext()) {
			System.out.print(solution.next() + " < ");
		}
		System.out.println("");
	}
}
