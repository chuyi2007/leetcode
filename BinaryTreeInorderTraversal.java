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
    public List<Integer> inorderTraversal(TreeNode root) {
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
                st.push(node);
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

// Without changing the tree
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
