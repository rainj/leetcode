package algorithms.q0173;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> parentStack;

	public BSTIterator(TreeNode root) {
		parentStack = new Stack<TreeNode>();
		while (root != null) {
			parentStack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !parentStack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode current = parentStack.pop();
		if (current.right != null) {
			TreeNode node = current.right;
			parentStack.push(node);
			while(node.left != null) {
				node = node.left;
				parentStack.push(node);
			}
			
		}
		
		return current.val;
	}
}