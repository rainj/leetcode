package algorithms.q0297;

/**
 * Created by rjiang on 3/30/16.
 */
public class Solution001 implements Solution {
    @Override
    public String serialize(TreeNode root) {
        if(null == root) {
            return "[]";
        }
        return recvSeriablize(root);
    }

    private String recvSeriablize(TreeNode node) {
        if(null == node) {
            return "null";
        }
        String leftResult = recvSeriablize(node.left);
        String rightResult = recvSeriablize(node.right);
        return new StringBuilder().append(node.val).append(",").append(leftResult).append(",").append(rightResult).toString();
    }

    @Override
    public TreeNode deserialize(String data) {
        return null;
    }
}
