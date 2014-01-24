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
    //O(N)
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recursion(root, root);
    }
    
    //O(N)
    public boolean recursion(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        else if (n1 == null || n2 == null) {
            return false;
        }
        else if (n1.val == n2.val) {
            return recursion(n1.left, n2.right)
                && recursion(n1.right, n2.left);
        }
        else {
            return false;
        }
    }
}