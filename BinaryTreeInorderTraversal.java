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
<<<<<<< Updated upstream
}
=======

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

    
>>>>>>> Stashed changes
