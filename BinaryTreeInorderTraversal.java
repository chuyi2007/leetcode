/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursion
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(node == null)
	    return new ArrayList<Integer>();
        result.addAll(inorderTraversal(node.left));
        result.add(node.val);
        result.addAll(inorderTraversal(node.right));
        return result;
    }
}

//iteration 1
public class Solution{
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!st.isEmpty() || cur != null){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            else{
                cur = st.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}

//iteration 2
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!st.isEmpty() && st.peek() != null){
            TreeNode node = st.pop();
            if(node.right != null)
                st.push(node.right);
            if(node.left != null){
                st.push(node);
                st.push(node.left);
            }
            else
                result.add(node.val);
            node.left = null;
            node.right = null;
        }
        return result;
    }
}