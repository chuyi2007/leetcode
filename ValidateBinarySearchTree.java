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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode node, int min, int max){
        if(node != null){
            if(node.val > min && node.val < max)
                return isValidBST(node.left, min, node.val)
                && isValidBST(node.right, node.val, max);
            else
                return false;
        }
        return true;
    }
}