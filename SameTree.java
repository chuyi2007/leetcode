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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (p == null && q == null) {
        	return true;
        }
        else if(p == null || q == null) {
        	return false;
        }
        else {   
        	return p.val == q.val 
                && isSameTree(p.left, q.left) 
                && isSameTree(p.right, q.right);
        }
    }
}