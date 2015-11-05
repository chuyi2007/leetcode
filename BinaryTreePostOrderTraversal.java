/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Without modifying the tree
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        List<Integer> res = new LinkedList<>();
        while (node != null) {
            res.add(0, node.val);
            if (node.left != null) {
                st.push(node.left);
            }
            node = node.right;
            if (node == null & !st.isEmpty()) {
                node = st.pop();
            }
        }
        return res;
    }
}
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        List<Integer> res = new ArrayList<>();
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.left == null && node.right == null) {
                res.add(node.val);
            } else {
                st.push(node);
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
                node.left = null;
                node.right = null;
            }
        }
        return res;
    }
}
