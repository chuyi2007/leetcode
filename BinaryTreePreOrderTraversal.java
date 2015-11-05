/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Modified the tree
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
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
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
                st.push(node);
                node.left = null;
                node.right = null;
            }
        }
        return res;
        
    }
}

// Without changing the tree
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            result.add(node.val);
            if (node.right != null) {
                st.push(node.right);
            }
            node = node.left;
            if (node == null && !st.isEmpty()) {
                node = st.pop();
            }
        }
        return result;
    }
}
