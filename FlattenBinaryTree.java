/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//O(N)
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode cur = null;
        while (!st.isEmpty() && st.peek() != null) {
            TreeNode parent = st.pop();
            if (parent.right != null) {
                st.push(parent.right);
            }
            if (parent.left != null) {
                st.push(parent.left);
            }
            parent.right = null;
            parent.left = null;
            if (parent == root) {
                cur = parent;
            }
            else {
                cur.right = parent;
                cur = cur.right;
            }
        }
    }
}