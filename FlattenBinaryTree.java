/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode cur = root;
        while (!st.isEmpty() && st.peek() != null) {
            TreeNode node = st.pop();
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
            if (cur != node) {
                cur.right = node;
                cur = cur.right;
            }
            node.left = null;
            node.right = null;
        }
    }
}