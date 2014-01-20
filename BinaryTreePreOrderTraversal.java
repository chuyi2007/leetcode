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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        
        while (!st.isEmpty() && st.peek() != null) {
            TreeNode node = st.pop();
            if (node.left == null && node.right == null) {
                sortedList.add(node.val);
            }
            else {
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
                st.push(node);
            }
            node.left = null;
            node.right = null;
        }
        
        return sortedList;
    }
}