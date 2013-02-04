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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
    
    public ArrayList<Integer> naiveRecursion(TreeNode node){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(node == null)    return new ArrayList<Integer>();
        ArrayList<Integer> tmp = naiveRecursion(node.left);
        for(Integer i: tmp) result.add(i);
        result.add(node.val);
        tmp = naiveRecursion(node.right);
        for(Integer i: tmp) result.add(i);
        return result;
    }

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