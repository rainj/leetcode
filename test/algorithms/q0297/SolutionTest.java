package algorithms.q0297;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by rjiang on 3/2/16.
 */
public class SolutionTest {

    Solution solution;

    @Before
    public void initialize() {
        solution = new Solution001();
    }

    @Test
    public void testSerialize12345() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.print(solution.serialize(root));
    }

    @Test
    public void testReverseNull() {

    }


}
